package Algorithm.dp;

/**
 * @program: CristianoRonaldo
 * @description: 给定一个数组 和 target，在这个数组里 选择出一堆数字加起来等于 target，假设所有数字都是正整数
 * 如果存在这么一堆数字，返回 true
 * 如果不存在，返回 -1（target = -1 是么得选择）
 * @author: wang chi
 * @create: 2020-06-23 15:32
 */
public class T_002 {

    public static boolean subSet (int[] arr, int i, int s){
        if (s == 0){
            return true;
        } else if (i == 0){
            return arr[i] == s;
        } else if (arr[i] > s){
            return subSet(arr, i-1, s);
        } else {
            return subSet(arr, i-1, s) || subSet(arr, i-1, s-arr[i]);
        }
    }

    public static boolean dp_subset (int[] arr, int s){

        boolean[][] flags = new boolean[arr.length][s+1];
        for (int i = 0; i < flags.length; i++) {
            flags[i][0] = true;
        }
        for (int i = 1; i < flags[0].length; i++) {
            flags[0][i] = false;
        }
        if (s >= arr[0]){
            flags[0][arr[0]] = true;
        }
        for (int i = 1; i < flags.length; i++) {
            for (int j = 1; j < s+1; j++) {
                if (arr[i] > j) {
                    flags[i][j] = flags[i-1][j];
                } else {
                    boolean A = flags[i-1][j - arr[i]];
                    boolean B = flags[i-1][j];
                    flags[i][j] = A || B;
                }
            }
        }
        return flags[arr.length-1][s];
    }

//    public static boolean dp_subset(int[] arr, int S) {
//        boolean[][] subset = new boolean[arr.length][S+1];
//        for(int i = 0;i<arr.length;i++) {
//            subset[i][0] = true;
//        }
//        for(int i = 0;i<S+1;i++) {
//            subset[0][i] = false;
//        }
//        if(S>=arr[0]) {
//            subset[0][arr[0]]=true;
//        }
//        for(int i = 1;i<arr.length;i++) {
//            for(int s=1;s<S+1;s++) {
//                if(arr[i] >s){
//                    subset[i][s] = subset[i-1][s];
//                }
//                else {
//                    boolean a = subset[i-1][s-arr[i]];
//                    boolean b = subset[i-1][s];
//                    subset[i][s] = a||b;
//                }
//            }
//        }
//        return subset[arr.length-1][S];
//    }



    public static void main(String[] args) {

        int[] arr = new int[]{3,34,4,12,5,2};

        System.out.println(subSet(arr,5,9));
        System.out.println(subSet(arr,5,10));
        System.out.println(subSet(arr,5,11));
        System.out.println(subSet(arr,5,12));
        System.out.println(subSet(arr,5,13));

        System.out.println(dp_subset(arr, 9));
        System.out.println(dp_subset(arr, 10));
        System.out.println(dp_subset(arr, 11));
        System.out.println(dp_subset(arr, 12));
        System.out.println(dp_subset(arr, 13));

    }
}
