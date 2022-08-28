package algorithm.niukewang;


import java.util.HashSet;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: wang chi
 * @create: 2020-06-30 02:01
 */

public class N_027_1 {

    static void printArray(int [] arr, int n){

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void swap(int [] arr, int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    static void permutation(int [] arr, int p, int q){

        if (p == q){
            printArray(arr, q + 1);
        } else {
            HashSet<Integer> set = new HashSet<>();
//            set.add(arr[p]);
            for (int i = p; i <= q; i++) {
                if(set.contains(arr[i])) {
                    continue; // 重复，因此剪枝
                }

                swap(arr, p, i);
                permutation(arr, p + 1, q);
                swap(arr, p, i);
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2 ,2};
        permutation(arr, 0, 2);


    }
}
