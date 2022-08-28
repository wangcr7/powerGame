package algorithm.niukewang;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * l -> r: dir 向下 u++;
 * u -> d: dir 向左 r--;
 * r -> l: dir 向上 d--;
 * d -> u: dir 向右 l++;
 * @author: wang chi
 * @create: 2020-06-19 11:29
 */
public class N_019 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[] ret = new int[row * col];


        int left = 0;
        int right = col - 1;
        int upper = 0;
        int down = row - 1;

        int index = 0;

        while (index < ret.length){

            for (int i = left; i <= right; i++) {
                ret[index++] = matrix[upper][i];
                if (index == ret.length){
                    break;
                }
            }
            upper++;
            for (int i = upper; i <= down; i++) {
                ret[index++] = matrix[i][right];
                if (index == ret.length){
                    break;
                }
            }
            right--;
            for (int i = right;i >= left;i--){
                ret[index++] = matrix[down][i];
                if (index == ret.length){
                    break;
                }
            }
            down--;
            for (int i = down;i >= upper;i--){
                ret[index++] = matrix[i][left];
                if (index == ret.length){
                    break;
                }
            }
            left++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ret.length; i++) {
            list.add(ret[i]);
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = printMatrix(arr);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

//        System.out.println(arr[0].length);

    }
}
