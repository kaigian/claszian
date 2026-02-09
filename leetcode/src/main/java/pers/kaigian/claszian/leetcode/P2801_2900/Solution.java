package pers.kaigian.claszian.leetcode.P2801_2900;

/**
 * @author kaigian
 */
public class Solution {
    /**
     * P2810:输入一个字符串，每当遇到字符 'i' 时，会反转你所写的字符串，而输入其他字符则可以正常工作
     */
    public String finalString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                res = reverse(res);
            } else {
                res = res + s.charAt(i);
            }
        }
        return res;
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
