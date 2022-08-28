package test;


/**
 * 大数相加
 */
public class BeKeTest {


    public String BigNumberMerge (String str1, String str2) {
        char [] chars1 = new StringBuilder(str1).reverse().toString().toCharArray();
        char [] chars2 = new StringBuilder(str2).reverse().toString().toCharArray();

        int length = chars1.length > chars2.length ? chars1.length : chars2.length;

        char [] chars3  = new char[length + 1];

        int carry = 0; //

        int i = 0;
        int j = 0;

        int k = 0;

        while ( i < chars1.length || j < chars2.length) {

            int sum = chars1[i] + chars2[j] + carry;

            // 计算进位
            carry = sum / 10;
            // 计算要存入的值
            int y = sum % 10;
//            chars3[k] = y;
            i ++;
            j ++;
            k ++;
        }

        while (i < chars1.length && j == chars2.length) {

            chars3[k ++ ] = chars1[i ++];
        }
        while (j < chars2.length && i == chars1.length) {
            chars3[k ++ ] = chars2[j ++];
        }
        return null;
    }

    public static void main(String[] args) {






    }
}
