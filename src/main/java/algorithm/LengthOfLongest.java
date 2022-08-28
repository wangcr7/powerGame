package algorithm;

public class LengthOfLongest {

    // 暴力解法
    // 时间 n的3次方
    public String longestPalindrome (String s ){
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char [] chars = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean validPalindromic (char [] chars, int left, int right) {

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 中心扩散法
    public String longestPalindrome1 (String s ) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        char [] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(chars, i , i);
            int evenLen = expandAroundCenter(chars, i , i+ 1);
            int curLen = Math.max(oddLen, evenLen);
            if (curLen > maxLen) {
                maxLen = curLen;
                begin = i- (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     *
     * @param chars
     * @param left
     * @param right
     * @return 回文串的长度
     */
    private int expandAroundCenter (char [] chars, int left , int right) {
        int len = chars.length;
        int i = left;
        int j = right;
        while (i > 0 && j < len) {
            if (chars[i] == chars[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }


}
