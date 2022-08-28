package leetcode;

import java.util.HashMap;

/**
 * @Title: T_3
 * @Package: leetcode
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: wangchi
 * @Date: 2022/8/28 - 4:45 PM
 */
public class T_3 {

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
