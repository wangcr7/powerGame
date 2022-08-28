package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: wang chi
 * @create: 2020-06-17 19:13
 */
public class N_006_1 {

    public int minNumberInRotateArray(int [] array) {

        int start = 0,end = array.length - 1;
        while (start < end){

            int mid = start + (end - start)/2;

            if (array[start] < array[end]){
                return array[start];
            }
            if (array[start] < array[mid]){
                start = mid + 1;

            } else if (array[mid] < array[end]){

                end = mid;
            } else {
                start++;
            }
        }
        return array[start];
    }
}
