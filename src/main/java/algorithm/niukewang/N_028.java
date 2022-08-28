package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 解题思路：如果两个数不相等，就消去这两个数，最坏情况下，每次消去一个众数和一个非众数，那么如果存在众数，最后留下的数肯定是众数。
 * @author: wang chi
 * @create: 2020-08-09 17:33
 */
public class N_028 {

    public static int MoreThanHalfNum_Solution(int [] array) {
        int win = 0;
        int count = 0;

        for (int n : array){
            if (count == 0){
                win = n;
                count = 1;
            } else {
                if (win == n){
                    count++;
                } else {
                    count--;
                }
            }
        }

        int sum = 0;
        for (int n: array) {
            if (win == n){
                sum++;
            }
        }
        if (sum > array.length / 2){
            return win;
        }
        return 0;
    }

    public static int MoreThanHalfNum_Solution1(int [] array) {
        int count = 0;
        int win = 0;
        for (int n : array) {
            if (count == 0){
                win = n;
                count = 1;
            } else {
                if (win == n){
                    count++;
                } else {
                    count--;
                }
            }
        }

        int sum = 0;
        for (int n : array) {
            if (win == n){
                sum++;
            }
        }

        if (sum > array.length/2){
            return win;
        }
        return 0;
    }


    public static void main(String[] args) {

        int [] arr = new int[]{2,2,3,1,5,2,2,4,2};
//        System.out.println(MoreThanHalfNum_Solution1(arr));
        System.out.println(MoreThanHalfNum_Solution(arr));
    }

}
