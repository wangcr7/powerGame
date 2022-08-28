package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: wang chi
 * @create: 2020-06-17 00:41
 */
public class N_002 {

    public static String replaceSpace(StringBuffer str) {

        int oldLength = str.length() - 1;
        int count = 0;
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        int newLength = oldLength + count * 2;
        str.setLength(newLength + 1);
        for (; oldLength >= 0 && oldLength <= newLength;oldLength--,newLength--){
            if (str.charAt(oldLength) != ' '){
                str.setCharAt(newLength, str.charAt(oldLength));
            } else {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength, '%');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("hello world ds wangchi ww");
        System.out.println(replaceSpace(stringBuffer));
//        stringBuffer.setLength(12);
//        stringBuffer.setCharAt(12, 's');
    }
}
