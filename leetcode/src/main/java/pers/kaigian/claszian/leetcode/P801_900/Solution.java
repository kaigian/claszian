package pers.kaigian.claszian.leetcode.P801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kaigian
 */
public class Solution {
    /**
     * P844:比较含退格的字符串
     */
    public boolean backspaceCompare(String s, String t) {
        int idxS = s.length() - 1, idxT = t.length() - 1, skipS = 0, skipT = 0;
        while (idxS >= 0 || idxT >= 0) {
            while (idxS >= 0) {
                if (s.charAt(idxS) == '#') {
                    skipS++;
                    idxS--;
                    continue;
                } else {
                    if (skipS == 0) {
                        break;
                    }
                    skipS--;
                    idxS--;
                }
            }
            while (idxT >= 0) {
                if (t.charAt(idxT) == '#') {
                    skipT++;
                    idxT--;
                    continue;
                } else {
                    if (skipT == 0) {
                        break;
                    }
                    skipT--;
                    idxT--;
                }
            }
            if (idxS < 0 && idxT < 0) {
                return true;
            }
            if ((idxS >= 0 && idxT < 0) || (idxT >= 0 && idxS < 0)) {
                return false;
            }
            if (s.charAt(idxS) != t.charAt(idxT)) {
                return false;
            }
            idxS--;
            idxT--;
        }
        return true;
    }

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "nzp#o#g", t = "b#nzp#o#g";
        System.out.println(solution.backspaceCompare(s, t));
    }
}
