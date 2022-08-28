package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: wang chi
 * @create: 2020-06-16 14:14
 */
public class N_001_1 {

    public boolean Find(int target, int [][] array) {

        int hang = array.length - 1;
        int lie = 0;
        boolean found = false;
        while (hang >= 0 && lie < array[0].length){
            if (array[hang][lie] < target){
                lie++;
            } else if (array[hang][lie] == target){
                found = true;
                break;
            } else if (array[hang][lie] > target){
                hang--;
            }
        }
        return found;
    }

    public static void main(String[] args) {

        int [][] arr = new int[3][4];
//        System.out.println(arr.length);
        System.out.println(arr[0].length);


    }


}
