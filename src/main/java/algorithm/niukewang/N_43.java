package algorithm.niukewang;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class N_43 {

    public static String LeftRotateString(String str,int n) {

        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, len + n);
    }

    public static String LeftRotateString1(String str,int n){

        str = new StringBuilder(str).reverse().toString();

        String str1 = new StringBuilder(str.substring(0, str.length() - n)).reverse().toString();

        String str2 = new StringBuilder(str.substring(str.length() - n)).reverse().toString();

        return str1 + str2;
    }




    public static void main(String[] args) {
        String S="abcXYZdef";

        // 左闭右开
        System.out.println(S.substring(0, 3));
        System.out.println(LeftRotateString1(S, 3));


    }
}
