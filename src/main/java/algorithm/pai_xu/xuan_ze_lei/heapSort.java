package algorithm.pai_xu.xuan_ze_lei;

/**
 * @program: CristianoRonaldo
 * @description: 堆排序
 * @author: wang chi
 * @create: 2020-06-12 17:36
 */
public class heapSort {

    public static void sort(int a[], int n){
        // n = 9;
        for (int i = n/2;i > 0; i--){
            // i = 4
            // i 值为多少，就是依次将 i （i 作为父节点）后面的调整为大根堆
            sift(a, i, n);
        }
        for (int i = n;i > 0;i--){
            int t = a[i];
            a[i] = a[1];
            a[1] = t;
            System.out.print(a[i] + ",");
            sift(a, 1, i - 1);
        }
    }
    private static void sift(int a[],int low,int high){
        // low = 4, high = 9
        // low = 3, high = 9, i = 3, j = 6, x = 2
        // low = 2, high = 9, i = 2, j = 4, x = 43
        int i = low,j = i * 2,x = a[i];
        while (j <= high){
            if (j < high && a[j] < a[j+1]){
                j++;
            }
            if (x < a[j]){
                a[i] = a[j];
                i = j;
                j = i * 2;
            } else {
                break;
            }
        }
        a[i] = x;
    }


//    public static void sort1(int [] arr, int n){
//        for (int i = n/2; i > 0 ; i--) {
//            sift1(arr, i, n);
//        }
//        for (int i = n; i > 0 ; i--) {
//            int temp = arr[1];
//            arr[1] = arr[i];
//            arr[i] = temp;
//            System.out.print(arr[i] + ",");
//            sift1(arr, 1, i-1);
//
//        }
//    }
//
//    public static void sift1(int [] arr, int low, int high){
//
//        int i = low,j = i*2, x = arr[i];
//        while (j <= high){
//            if (j < high && arr[j] < arr[j+1]){
//                j++;
//            }
//            if (x < arr[j]){
//                arr[i] = arr[j];
//                i = j;
//                j = i * 2;
//            } else {
//                break;
//            }
//        }
//        arr[i] = x;
//    }


    public static void main(String[] args) {

        /**
         * arr.length = 10
         */
        int[] arr = new int[]{99999,3,143,2,63,4,32,4,1,2};


        heapSort.sort(arr, arr.length -1);

//        int i = 3;
//        i = i++;
//        System.out.println(i);

//        for (int k = 0; k < arr.length; k++) {
//            System.out.print(arr[k]+ ",");
//        }

    }
}
