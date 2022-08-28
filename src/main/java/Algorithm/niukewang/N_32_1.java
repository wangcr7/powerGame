package Algorithm.niukewang;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class N_32_1 {


    public String PrintMinNumber(int [] numbers) {

        if (numbers == null || numbers.length == 0){
            return "";
        }
        int len = numbers.length;
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {


        String str1 = "3";
        String str2 = "321";
        String str3 = "Strings123";

        int result = str1.compareTo( str2 );
        System.out.println(result);

        result = str2.compareTo( str3 );
        System.out.println(result);

        result = str3.compareTo( str1 );
        System.out.println(result);

    }
}
