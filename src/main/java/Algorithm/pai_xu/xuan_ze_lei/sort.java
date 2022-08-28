package Algorithm.pai_xu.xuan_ze_lei;

/**
 * @program: CristianoRonaldo
 * @description: 直接选择排序
 * @author: wang chi
 * @create: 2020-06-12 17:30
 */
public class sort {

    public static long[] sort(long[] arr){
        int i,j,k;
        long temp;
        for (i = 0; i < arr.length-1; i++) {
            k = i;
            // 找到最小的，用 k 指出
            for (j = i+1;j < arr.length;j++){
                if (arr[j] < arr[k]){
                    k = j;
                }
            }
            // 与 i 交换
            if (k != i){
                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }

}
