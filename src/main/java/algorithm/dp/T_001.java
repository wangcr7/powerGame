package algorithm.dp;

/**
 * @program: CristianoRonaldo
 * @description: 在一个数组中，选择一些数字使得加起来最大。选择的数字不能相邻
 * @author: wang chi
 * @create: 2020-06-23 15:07
 */
public class T_001 {

    /**
     * 到达下标为 i 的时候最大值
     * @param arr
     * @param i
     * @return
     */
    public static int rec_opt (int[] arr, int i){

        if (i == 0){
            return arr[0];
        } else if (i == 1){
            return Math.max(arr[0], arr[1]);
        } else {
            int a = rec_opt(arr, i - 2) + arr[i];
            int b = rec_opt(arr, i -1);
            return Math.max(a, b);
        }
    }

    public static int dp_opt (int[] arr, int length){

        int[] arr_max = new int[length];
        arr_max[0] = arr[0];
        arr_max[1] = Math.max(arr[0], arr[1]);
        for (int i = 2;i < length;i++){
            int a = arr_max[i-2] + arr[i];
            int b = arr_max[i-1];
            arr_max[i] = Math.max(a, b);
        }
        return arr_max[length-1];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,1,7,8,3,2,9,4,5,21,87,1,3};
        System.out.println(rec_opt(arr, 14));
        System.out.println(dp_opt(arr, 15));

    }
}
