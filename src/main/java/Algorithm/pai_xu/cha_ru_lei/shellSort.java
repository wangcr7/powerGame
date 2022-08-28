package Algorithm.pai_xu.cha_ru_lei;

/**
 * @program: CristianoRonaldo
 * @description: shell 排序
 * @author: wang chi
 * @create: 2020-06-12 15:08
 */
public class shellSort {

    public static void sort(long [] arr){
        int i,j,d = arr.length/2;
        long x;
        while (d > 0){
            for (i = d;i < arr.length;i++){
                x = arr[i];
                for (j = i-d;j > -1 && x < arr[j];arr[j+d] = arr[j],j-=d);
                arr[j+d] = x;
            }
            d /= 2;
        }
    }

    public static void sort1(long [] arr){
        int i,j,d = arr.length/2;
        long x;
        while (d > 0){
            for (i = d;i < arr.length;i++){
                x = arr[i];
                j = i - d;
                while (j > -1 && arr[j] > x){
                    arr[j+d] = arr[j];
                    j = j - d;
                }
                arr[j+d] = x;
            }
            d /= 2;
        }
    }
}
