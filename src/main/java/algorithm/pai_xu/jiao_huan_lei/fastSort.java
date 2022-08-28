package algorithm.pai_xu.jiao_huan_lei;

/**
 * @program: CristianoRonaldo
 * @description: 快速排序
 * @author: wang chi
 * @create: 2020-06-12 16:13
 */
public class fastSort {

    public static long[] sort(long [] arr, int low, int high){
        // low = 0, high = 5
        int i,j;
        long x = 0;
        if (low < high){
            x = arr[low];
            i = low + 1;
            j = high;
            while (i < j){
                for (;i < high && arr[i] <= x;i++);
                for (;j > low && arr[j] > x;j--);
                if (i < j){
                    long s = arr[i];
                    arr[i] = arr[j];
                    arr[j] = s;
                }
            }
            if (arr[low] > arr[j]){
                long z = arr[low];
                arr[low] = arr[j];
                arr[j] = z;
            }
            sort(arr, low, j-1);
            sort(arr, j+1, high);
        }
        return arr;
    }

    public static void main(String[] args) {

        // 一次快速排序就成功---1 2 3 6 7（此时 将 3 排序到正确位置）
        // 递归的时候 1 2 和 6 7 ，没有 if 判断直接就 arr[low] 和 arr[j] 交换，导致出错，最终变成 2 1 3 7 6
        long[] arr = new long[]{3,2,1,6,7};

        arr = fastSort.sort(arr, 0, arr.length - 1);

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+ ",");
        }

    }
}
