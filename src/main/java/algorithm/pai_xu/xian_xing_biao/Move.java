package algorithm.pai_xu.xian_xing_biao;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: wang chi
 * @create: 2020-06-18 15:06
 */
public class Move {


    /**
     * 将所有的偶数移动到奇数之后，且相对位置不变
     * @param array
     * @return
     */
    public static int[] reOrderArray(int [] array) {

        int i,j,x;
        int n = array.length;
        int count = 0;
        int flag = n/2;

        for (i = 0;i < n;){
            if (array[i] % 2 == 1){
                i++;
            } else {
                x = array[i];
                for (j = i;j < n-1;j++){
                    array[j] = array[j+1];
                }
                array[j] = x;
                count++;
                if (count == flag){
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 将所有的偶数移动到奇数之后
     * @param array
     * @return
     */
    public static int[] reOrderArray1(int [] array) {
        int j;
        int n = array.length;

        for (int i = 0;i < n;){
            if (array[i] % 2 == 1){
                i++;
            } else {
                int x = array[i];
                for (j = i;j < n-1;j++){
                    array[j] = array[j+1];
                }
                array[j] = x;
                n--;
            }
        }
        return array;
    }

    /**
     * 将所有的偶数移动到奇数之后
     * @param array
     * @return
     */
    public static int[] reOrderArray2(int [] array) {

        int i = 0;
        int j = array.length - 1;
        int n = array.length;
        while (i < j){
            for (; i < n && array[i] % 2 == 1;i++);
            for (; j > -1 && array[j] % 2 == 0;j--);
            if (i < j){
                int x = array[i];
                array[i] = array[j];
                array[j] = x;
            }
        }
        return array;
    }

    /**
     * 将所有的偶数移动到奇数之后
     * @param array
     * @return
     */
    public static int[] reOrderArray3(int [] array) {
        int i,j,x;
        int n = 8;
        for (i = 0;i < n;){
            if (array[i] % 2 == 1){
                i++;
            } else {
                for (j = i;j < n-1; j++){
                    x = array[j];
                    array[j] = array[j+1];
                    array[j+1] = x;
                }
                n--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,5,8,4,7,6,9};
        array = reOrderArray1(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
