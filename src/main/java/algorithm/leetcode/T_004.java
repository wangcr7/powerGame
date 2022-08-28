package algorithm.leetcode;

/**
 * 最长回文子串
 */
public class T_004 {

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int L = 2; L < chars.length; L++) {

            for (int i = 0; i < len; i++) {

                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {

            int oddLen = expandAroundCenter(chars, i, i );
            int evenLen = expandAroundCenter(chars, i , i+1);
            int curLen = Math.max(oddLen, evenLen);

            if (curLen > maxLen) {
                maxLen = curLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private int expandAroundCenter(char[] chars, int left, int right) {

        int len = chars.length;
        int i = left;
        int j = right;
        while (i > 0 && j < len) {
            if (chars[i] == chars[j]) {
                j--;
                i++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }
}
