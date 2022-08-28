package algorithm.di_gui;

/**
 * @program: CristianoRonaldo
 * @description: （1）对原有问题 f(n) 进行分析，称为"大问题"，假设出合理的小问题 f(n`)
 * （2）假设 f(n`) 是可解的，在此基础上确定 f(n) 的解，即给出 f(n) 和 f(n`) 之间的关系
 * （3）确定一个特殊的情况(如 f(0) 或者 f(1) 的解释) ---> 递归出口
 * @author: wang chi
 * @create: 2020-06-15 15:36
 */
public class T_001 {

    /**
     * 输出给的的 x 的各个数字之和
     */
    public static int sum (int x){
        if (x == 0){
            return 0;
        } else {
            return x % 10 + sum(x/10);
        }
    }

    public static void main(String[] args) {

//        System.out.println(sum(123));
        System.out.println(1 / 10);
    }

}
