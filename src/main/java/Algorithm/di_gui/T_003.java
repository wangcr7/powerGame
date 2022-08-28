package Algorithm.di_gui;

/**
 * @program: CristianoRonaldo
 * @description: 使用递归实现 斐波拉契 数列
 * @author: wang chi
 * @create: 2020-06-15 15:57
 */
public class T_003 {

    public static int Test(int x){
        if (x == 1){
            return 1;
        } else if (x == 2){
            return 2;
        } else {

            return Test(x - 1) + Test(x - 2);
        }
    }

    public static void main(String[] args) {

        System.out.println(Test(5));
    }

}
