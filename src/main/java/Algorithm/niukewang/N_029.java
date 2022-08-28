package Algorithm.niukewang;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-10-12 16:38
 */
public class N_029 {


    /**
     * 第一种方式，排序
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        int arr[] = fastSort (input, 0 ,input.length - 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static int[] fastSort(int [] arr, int low, int high){
        int i, j;
        int x;
        if (low <= high){
            x = arr[low];
            i = low + 1;
            j = high;
            while (i < j){
                for (; i < high && x > arr[i]; i++);
                for (; j > low && x <= arr[j]; j--);
                if (i < j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (arr[low] > arr[j]){
                int temp = arr[low];
                arr[low] = arr[j];
                arr[j] = temp;
            }
            fastSort(arr, low, j-1);
            fastSort(arr, j+1, high);
        }
        return arr;
    }

    //----------------------------------------------------------------------------------------

    /**
     * 第二种方式，冒泡
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k){

        int arr[] = maopao(input, k);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private static int[] maopao(int [] arr, int k){
        for (int i = 0;i < k;i++){

            boolean flag = true;
            for (int j = arr.length - 1; j > i ; j--) {

                if (arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }

    //----------------------------------------------------------------------------------------

    /**
     * 第三种方式，堆排序
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){

        int arr [] = new int[input.length + 1];
        arr[0] = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            arr[i+1] = input[i];
        }
        return heapSort(arr, arr.length-1, k);
    }

    private static ArrayList<Integer> heapSort(int [] arr, int n, int k){

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n/2; i > 0; i--) {
            diff(arr, i, n);
        }
        for (int i = n; i > n-k ; i--) {
            list.add(arr[1]);
            int t = arr[i];
            arr[i] = arr[1];
            arr[1] = t;
            diff(arr, 1, n-1);
        }
        return list;
    }

    private static void diff(int [] arr, int low, int high){

        int i = low, j = i*2, x = arr[i];
        while (j <= high){
            if (j < high && arr[j] < arr[j+1]){
                j = j + 1;
            }
            if (x < arr[j]){
                arr[i] = arr[j];
                i = j;
                j = j*2;
            }
        }
        arr[i] = x;
    }

    //----------------------------------------------------------------------------------------

    /**
     * 减治法
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k){

        return new ArrayList<>();
    }


    public static void main(String[] args) {
        int arr[] = {3,2,8,4,6,9};
        List list = GetLeastNumbers_Solution2(arr, 3);
        for (int i = 0;i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
//        arr = maopao(arr, 3);
//        for (int i = 0;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }
    }
}
