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
}
