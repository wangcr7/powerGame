package algorithm.pai_xu.xian_xing_biao;

/**
 * @program: CristianoRonaldo
 * @description: 将两个有序数组合并一个有序数组
 * @author: wang chi
 * @create: 2020-06-18 16:50
 */
public class Merge {

    /**
     * 将两个有序数组合并为一个有序数组
     * @param arr1
     * @param arr2
     */
    public static void Merge(int[] arr1,int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0,j = 0,k = 0;
        int[] arr3 = new int[m+n];
        while (i < n || j < m){
            if (j == m || (i < n && arr1[i] < arr2[j])){
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,3,5,7};
        int[] arr2 = new int[]{2,4,6,8};
        Merge(arr1, arr2);
    }
}
