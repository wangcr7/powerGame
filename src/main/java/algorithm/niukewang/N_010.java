package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * @author: wang chi
 * @create: 2020-06-18 13:43
 */
public class N_010 {

    public int RectCover(int target) {

        if (target <= 2){
            return target;
        }

        int pre1 = 2;
        int pre2 = 1;

        for (int i = 3; i <= target;i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
