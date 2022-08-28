package Algorithm.di_gui;

/**
 * @program: CristianoRonaldo
 * @description: 给定一个正整数，输出它的二进制码
 * @author: wang chi
 * @create: 2020-06-15 15:36
 */
public class T_002 {

    public static void Test(int x){

        if (x == 0){
            return;
        } else {
            Test(x / 2);
            System.out.print(x % 2);
        }
    }

    public static void main(String[] args) {

        Test(32);
    }
}
