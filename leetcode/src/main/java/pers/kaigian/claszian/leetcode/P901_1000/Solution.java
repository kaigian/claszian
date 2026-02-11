package pers.kaigian.claszian.leetcode.P901_1000;

import java.util.*;

public class Solution {
    /**
     * P904:水果成篮
     */
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int left = 0, right = 0, cnt = 0, ans = 0;
        while (right < fruits.length) {
            if (left > right) {
                right++;
                continue;
            }
            if (cntMap.containsKey(fruits[right]) || cntMap.keySet().size() < 2) {
                cntMap.put(fruits[right], cntMap.getOrDefault(fruits[right], 0) + 1);
                right++;
                cnt++;
                ans = Math.max(ans, cnt);
                continue;
            }
            Integer tmpCnt = cntMap.get(fruits[left]);
            if (tmpCnt == 1) {
                cntMap.remove(fruits[left]);
            } else {
                cntMap.put(fruits[left], tmpCnt - 1);
            }
            cnt--;
            left++;
        }
        return ans;
    }

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
