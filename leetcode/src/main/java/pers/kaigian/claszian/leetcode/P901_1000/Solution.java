package pers.kaigian.claszian.leetcode.P901_1000;

public class Solution {
    /**
     * P977:有序数组的平方
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, idx = nums.length - 1;
        while (left <= right) {
            int tmpLeft = nums[left] * nums[left];
            int tmpRight = nums[right] * nums[right];
            if (tmpLeft >= tmpRight) {
                result[idx--] = tmpLeft;
                left++;
            } else {
                result[idx--] = tmpRight;
                right--;
            }
        }
        return result;
    }
}
