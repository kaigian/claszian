package pers.kaigian.claszian.leetcode.P201_300;

public class Solution {
    /**
     * P209:长度最小的子数组
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[0], result = 0;
        while (right < nums.length) {
            if (right < left) {
                right++;
                continue;
            }
            if (sum >= target) {
                if (result == 0) {
                    result = right - left + 1;
                } else {
                    result = Math.min(result, right - left + 1);
                }
                sum -= nums[left++];
                continue;
            }
            if (right == nums.length - 1) {
                break;
            }
            sum += nums[++right];
        }
        return result;
    }

    /**
     * P283:移动零
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
                continue;
            }
            int tmp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = tmp;
            slow++;
            fast++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(solution.minSubArrayLen(7, nums));
    }
}
