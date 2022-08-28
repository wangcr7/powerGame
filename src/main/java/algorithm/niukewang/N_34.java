package algorithm.niukewang;


import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class N_34 {

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        char [] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null){
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1){
                index = i;
                break;
            }

        }
        return index;
    }

    public static void main(String[] args) {

    }
}
