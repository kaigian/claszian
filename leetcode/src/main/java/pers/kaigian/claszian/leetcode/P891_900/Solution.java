package pers.kaigian.claszian.leetcode.P891_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kaigian
 */
public class Solution {
    /**
     * P894
     */
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        for (int i = 1; i <= n; i += 2) {
            List<TreeNode> nodes = new ArrayList<>();
            if (i == 1) {
                nodes.add(new TreeNode(0));
                map.put(i, nodes);
                continue;
            }
            for (int left = 1; left < i; left += 2) {
                int right = i - 1 - left;
                List<TreeNode> leftTree = map.get(left), rightTree = map.get(right);
                for (TreeNode leftNode : leftTree) {
                    for (TreeNode rightNode : rightTree) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        nodes.add(deepCopy(root));
                    }
                }
            }
            map.put(i, nodes);
        }
        return map.get(n);
    }

    private TreeNode deepCopy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = deepCopy(root.left);
        newNode.right = deepCopy(root.right);
        return newNode;
    }
}
