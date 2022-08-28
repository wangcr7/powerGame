package Algorithm.pai_xu.jiao_huan_lei;

/**
 * @program: CristianoRonaldo
 * @description: 冒泡排序
 *
 * 1、外层一次循环就是冒一次泡
 * 2、注意没有进入 if 交换就已经排序成功
 * @author: wang chi
 * @create: 2020-06-12 17:12
 */
public class maopao {

    public static long[] sort(long [] arr){
        long temp;
        boolean tag;
        for (int i = 0;i < arr.length-1;i++){
            tag = true;
            // j 每次从最后一个数开始，和它前一个数比较
            for (int j = arr.length-1;j > i;j--){
                if (arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    tag = false;
                }
            }
            if (tag){
                break;
            }
        }
        return arr;
    }

    public static long[] sort1(long [] arr){

        for (int i = 0; i < arr.length - 1; i++) {

            boolean tag = true;

            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j-1]){
                    long temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    tag = false;
                }
            }

            if (tag){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        long[] arr = new long[]{5,3,1,2,6,4};

        arr = maopao.sort1(arr);

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+ ",");
        }

    }
}
