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

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 0));
    }
}
