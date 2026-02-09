package pers.kaigian.claszian.leetcode.P301_400;

import java.util.Stack;

/**
 * @author kaigian
 */
public class Solution {
    /**
     * P331:给出一个二叉树的前序，验证其是否合法
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (String node : nodes) {
            if (stack.isEmpty()) {
                return false;
            }
            int cur = stack.pop() - 1;
            if (cur > 0) {
                stack.push(cur);
            }
            if (!"#".equals(node)) {
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /**
     * P367:有效的完全平方数
     */
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long tmp = (long) mid * mid;
            if (tmp > num) {
                right = mid - 1;
            } else if (tmp < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }
}
