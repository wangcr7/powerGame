package algorithm.pai_xu.cha_ru_lei;

/**
 * @program: CristianoRonaldo
 * @description:直接插入类：
 * 思想：
 * @author: wang chi
 * @create: 2020-06-12 00:23
 */
public class sort {

    public static void sort(long [] arr){
        int i,j;
        long x;
        for (i = 1;i < arr.length;i++){
            x = arr[i];
            for (j = i-1;j > -1 && x < arr[j];arr[j+1] = arr[j],j--);
            arr[j+1] = x;
        }
    }

    public static void sort1(long [] arr){
        int i,j;
        long x;
        for (i = 1; i < arr.length; i++) {
            x = arr[i];
            j = i - 1;
            while (j > -1 && x < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }
    }
}
