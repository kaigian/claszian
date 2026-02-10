package pers.kaigian.claszian.leetcode.P201_300;

public class Solution {
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
}
