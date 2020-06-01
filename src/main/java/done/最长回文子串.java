package done;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int m = 0, n = 0, max = 0;
        int[] region;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                region = find(s, i, i + 1);
                if (region[1] - region[0] > max) {
                    max = region[1] - region[0];
                    m = region[0];
                    n = region[1];
                }
            }
            if (s.length() > 2 && i > 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                region = find(s, i - 1, i + 1);
                if (region[1] - region[0] > max) {
                    max = region[1] - region[0];
                    m = region[0];
                    n = region[1];
                }
            }
        }
        return s.substring(m, n + 1);
    }

    private int[] find(String s, int m, int n) {
        int i = m - 1, j = n + 1;
        if (i < 0 || j >= s.length()) {
            return new int[]{m, n};
        }
        if (s.charAt(i) == s.charAt(j)) {
            return find(s, i, j);
        }
        return new int[]{m, n};
    }
}
