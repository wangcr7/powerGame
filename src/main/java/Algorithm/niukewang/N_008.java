package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @author: wang chi
 * @create: 2020-06-17 20:47
 */
public class N_008 {

    public int JumpFloor(int target) {

        if (target == 1){
            return 1;
        } else if (target == 2){
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }

    }

    public int JumpFloor1(int target) {

        if (target == 1){
            return 1;
        } else if(target == 2){
            return 2;
        }
        int two = 1;
        int one = 2;
        int sum = one + two;
        for (int i = 3; i <= target; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;

    }

    public int JumpFloor2(int target) {
        int a = 1, b = 1;
        for (int i = 1; i < target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
