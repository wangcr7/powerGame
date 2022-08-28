package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
 * （从0开始，第0项为0，第1项是1）。
 * n<=39
 * @author: wang chi
 * @create: 2020-06-17 20:43
 */
public class N_007 {

    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1 || n == 2){
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public int Fibonacci1(int n){
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2;i <= n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }

    public int Fibonacci2(int n){
        if (n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        int two = 0;
        int one = 1;
        int sum = one + two;
        for (int i = 2; i < n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public int Fibonacci3(int n){
        if (n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        int sum = 1;
        int one = 0;
        for (int i = 2;i <= n;i++){
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 2; i++) {
            System.out.println(1);
        }
    }
}
