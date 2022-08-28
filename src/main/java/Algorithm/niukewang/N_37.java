package Algorithm.niukewang;

/**
 *
 * 统计一个数字在升序数组中出现的次数。
 */
public class N_37 {

    public static int GetNumberOfK(int [] array , int k) {

        if (array.length == 0) return 0;
        int left = left (array, k);
        int right = right (array, k);
        if (left == -1 || right == -1){
            return 0;
        }
        return right - left + 1;
    }


    // 寻找左侧边界
    private static int left (int [] array , int k){
        int left = 0;
        int right = array.length;
        while (left < right){
            int mid = (left + right)/2;
            if (array[mid] == k){
                right = mid;
            } else if (array[mid] > k){
                right = mid;
            } else if (array[mid] < k){
                left = mid + 1;
            }
        }
        if (left == array.length) return -1;
        return array[left] == k ? left : -1;
    }

    // 寻找右侧边界
    private static int right (int [] array , int k){
        int left = 0;
        int right = array.length;
        while (left < right){

            int mid = (left + right)/2;
            if (array[mid] == k){
                left = mid + 1;
            } else if (array[mid] < k){
                left = mid + 1;
            } else if (array[mid] > k){
                right = mid;
            }
        }
        if (left == 0) return -1;
        return array[left -1] == k ? left -1:-1;
    }


    public static int GetNumberOfK1(int [] array , int k) {
        return getPlace(array, k+0.5) -  getPlace(array, k-0.5);
    }

    private static int getPlace(int [] array , double k){

        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (array[mid] < k){
                left = mid + 1;
            } else if (array[mid] > k){
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int [] arr = new int[]{1, 2, 3,3,3,3,4,5};
        System.out.println(GetNumberOfK1(arr, 5));
    }
}
