package algorithm.niukewang;

/**
 *
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class N_49_1 {


    public static int StrToInt(String str) {

        char [] chars = str.trim().toCharArray();
        if (chars.length == 0){
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-'){
            sign = -1;
        } else  if (chars[0] != '+'){
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9'){
                break;
            }
            if (res > bndry || res == bndry && chars[j] > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {

        System.out.println(StrToInt("1a33"));
    }
}
