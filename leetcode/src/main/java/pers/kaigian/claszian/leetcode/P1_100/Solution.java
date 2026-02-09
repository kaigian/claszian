package pers.kaigian.claszian.leetcode.P1_100;

public class Solution {
    /**
     * P34:在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, start = nums.length, end = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                start = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (start > nums.length - 1 || nums[start] != target) {
            return new int[] { -1, -1 };
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                end = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] { start, end };
    }

    /**
     * P35:搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (left == right) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    return mid + 1;
                } else if (nums[mid] > target) {
                    return mid;
                }
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * P69:X的平方根
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = x;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if ((long) mid * mid > x) {
                ans = mid - 1;
                right = mid - 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
