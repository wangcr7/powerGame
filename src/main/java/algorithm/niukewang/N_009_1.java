package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 * @author: wang chi
 * @create: 2020-06-17 20:58
 */
public class N_009_1 {

    public static int JumpFloorII(int target) {
        if (target == 0 || target == 1){
            return 1;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2;i <= target;i++){
            for (int j = 0;j < i;j++){
                arr[i] = arr[i] + arr[j];
            }
        }
        return arr[target];
    }

    public static int JumpFloorIII(int target) {
        if (target == 0 || target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int a = 2;
        for (int i = 3; i <= target ; i++) {
            a = 2 * a;
        }
        return a;
    }


    static int jumpFloorIIIII(int n) {
        if (n==0 || n==1) return 1;
        int a = 1;
        for (int i=2; i<=n; ++i) {
            a = a << 1;
        }
        return a;
    }

    public int JumpFloorIIII(int target) {
        return target <= 0 ? 0 : 1 << (target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(15));
        System.out.println(jumpFloorIIIII(15));

    }
}
