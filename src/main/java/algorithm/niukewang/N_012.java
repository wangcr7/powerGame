package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @author: wang chi
 * @create: 2020-06-18 14:20
 */
public class N_012 {

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ret = 1.0;
        for (int i=0; i<exponent; ++i) ret *= base;
        return ret;
    }

}
