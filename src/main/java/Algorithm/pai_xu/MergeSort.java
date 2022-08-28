package Algorithm.pai_xu;

/**
 * @program: CristianoRonaldo
 * @description: 归并排序
 * @author: wang chi
 * @create: 2020-06-15 13:56
 */
public class MergeSort {

    public static void mergeSort(int [] arr){
        for (int length = 1; length < arr.length; length = length * 2){
            mergePass(arr, length);
        }
    }

    public static void mergePass(int [] arr, int length){

        int i;
        for (i = 0; i + 2 * length - 1 < arr.length; i = i + 2 * length){
            merge(arr, i, i + length - 1, i + 2 * length - 1);
        }
        if (i + length - 1 < arr.length){
            merge(arr, i, i + length - 1, arr.length - 1);
        }
    }

    public static void merge(int [] arr, int low, int mid, int high){
        int [] b = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high){
            if (arr[i] <= arr[j]){
                b[k++] = arr[i++];
            } else {
                b[k++] = arr[j++];
            }
        }
        if (j <= high){
            i = j;
            mid = high;
        }
        while (i <= mid){
            b[k++] = arr[i++];
        }
//        while (j <= high){
//            b[k++] = arr[j++];
//        }


//        while (i <= mid || j <= high){
//            if (j > high || (i <= mid && arr[i] <= arr[j])){
//                b[k++] = arr[i++];
//            } else {
//                b[k++] = arr[j++];
//            }
//        }

        for (k = 0, i = low; i <= high; k++,i++){
            arr[i] = b[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random()*99);
        }
        mergeSort(arr);
        for (int l = 0; l < arr.length; l++) {
            System.out.print(arr[l] + ",");
        }
    }
}
