package algorithm.niukewang;

/**
 *
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 */

public class N_30 {

    /**
     * 一般解法
     * @param arr
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        int Max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum <= 0){
                sum = arr[i];
            }else{
                sum += arr[i];
            }
            if(sum > Max){
                Max = sum;
            }
        }
        return Max;
    }

    /**
     * 动态规划解法
     * @param arr
     * @return
     */
    public static int FindGreatestSumOfSubArray1(int[] arr){

        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (dp[i-1] <= 0){
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i-1] + arr[i];
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(FindGreatestSumOfSubArray1(arr));
    }
}
