package algorithm.erfen;

/**
 * @program: CristianoRonaldo
 * @description: 二分查找
 * @author: wang chi
 * @create: 2020-06-16 14:21
 */
public class erfen_001 {

    /**
     * 普通二分
     * 1、为啥 while 循环里的条件是 <= 而不是 < ？
     *      因为初始化的时候 right = array.length-1，搜索区间是 [left, right] ，左闭右闭。
     *      而 left < right 的终止条件是 left = right，写成区间形式就是 [right, right]，这时候搜索区间非空，还有一个数字 right
     *      而 left <= right的终止条件是 left = right+1,写成区间形式就是[right+1,right]，没有一个数字既大于等于right+1，又小于等于right
     *
     * 2、为什么 left = mid + 1，right = mid - 1？我看有的代码是 right = mid 或者 left = mid，没有这些加加减减，到底怎么回事，怎么判断？
     *      本算法的搜索区间是两端都闭的，即[left,right]，当我们发现mid不是我们要找的target时，当然去搜索[left,mid-1]和[mid+1,right]
     */
    static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while(left <= right) {

            int mid = (right + left) / 2;
            if(array[mid] == target)
                return mid;
            else if (array[mid] < target)

                left = mid + 1;
            else if (array[mid] > target)

                right = mid - 1;
        }
        return -1;
    }
    /**
     * 寻找左侧边界的二分搜索，如果没找到则返回 -1
     *
     * 1、为啥 while 循环里的条件是 < 而不是 <= ？
     *      因为初始化的时候 right = array.length，搜索区间是 [left, right），左闭右开
     *      而 left < right 的终止条件是 left=right，写成区间形式就是[right, right)，这时候搜索区间刚好为空，所以可正确终止
     * 2、为什么 left = mid + 1，right = mid ？
     *      因为搜索区间是[left,right)左闭右开，所以当array[mid]被检测之后，下一步的搜索区间应该去掉mid分割成两个区间，即[left, mid) 或 [mid+1, right)
     * 3、为什么该算法能够搜索左侧边界？
     *      关键在于对于 array[mid] == target 这种情况的处理：right = mid;
     *      可见，找到 target 时不立即返回，而是缩小搜索区间的上界right，在区间[left, mid)中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。
     * 4、为什么返回 left 而不是 right？
     *      返回left和right都是一样的，因为while终止的条件是left==right
     */
    static int left_bound(int[] array, int target){
        if (array.length == 0){ return -1; }
        int left = 0;
        int right = array.length;
        while (left < right){
            int mid = (left + right)/2;
            if(array[mid] == target)
                right = mid;
            else if (array[mid] < target)
                left = mid + 1;
            else if (array[mid] > target)
                right = mid;
        }
        // 如果寻找的值 > 数组里所有的值
        if (left == array.length) return -1;
        // 如果寻找的值 < 数组里所有的值
        return array[left] == target ? left : -1;
    }
    /**
     * 寻找右侧边界的二分查找
     *
     * 1、为啥 while 循环里的条件是 < 而不是 <= ？
     *      因为初始化的时候 right = array.length，搜索区间是 [left, right），左闭右开
     *      而 left < right 的终止条件是 left=right，写成区间形式就是[right, right)，这时候搜索区间刚好为空，所以可正确终止
     * 2、为什么这个算法能够找到右侧边界？
     *      类似地，关键点还是这里：if (nums[mid] == target) {left = mid + 1;}
     * 3、 为什么最后返回 left - 1 而不像左侧边界的函数，返回 left？而且我觉得这里既然是搜索右侧边界，应该返回 right 才对。
     *      首先，while 循环的终止条件是 left = right，所以 left == right，如果非要体现 right，返回 right - 1 也可
     *      至于为什么要减一，这是搜索右侧边界的一个特殊点，关键在这个条件判断：if (nums[mid] == target) {left = mid + 1;}，这里对 left 的更新是 mid +1
     *      也就是 循环结束的时候，nums[left] 一定不等于 target 了，而 nums[left - 1]可能是target。
     *
     */
    static int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            // 当 nums[mid] == target 时，不要立即返回，而是增大「搜索区间」的下界 left，使得区间不断向右收缩，达到锁定右侧边界的目的。
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }



    /**
     * 旋转数组的二分
     * https://blog.csdn.net/bjweimengshu/article/details/90826510
     * 如果有旋转点的情况下
     *
     * 旋转点 与 中位数重合的话，arr[start] 必定 大于 中位数（旋转点是最小值）
     * 旋转点 如果在中位数的 左边，arr[start] 必定 大于 中位数
     *
     * 旋转点 如果在中位数的 右边，arr[start] 必定 小于等于 中位数
     *
     * 有序区间的判断是 [) (]，即 arr[start] 和 target 或者 arr[end] 和 target
     */
    static int rotatedBinarySearch(int[] arr, int target){
        int start = 0,end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid;
            }
            // 旋转点在中位数的右侧
            if (arr[start] <= arr[mid]){
                if (arr[start] <= target && target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 旋转数组的最左边界
     * @param nums
     * @param target
     * @return
     */
    static int find (int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        if (right == -1)
            return -1;
        // 循环结束条件left==right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果左值小于中值，说明左边区间升序
            if (nums[left] < nums[mid]) {
                // 如果目标在左边的升序区间中，右边界移动到mid
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                    // 否则目标在右半边，左边界移动到mid+1
                } else {
                    left = mid + 1;
                }
                // 如果左值大于中值，说明左边不是升序，右半边升序
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right] && nums[left] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                // 如果左值等于中值，可能是已经找到了目标，也可能是遇到了重复值
            } else if (nums[left] == nums[mid]) {
                // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                if (nums[left] != target) {
                    left++;
                    // 如果左值等于目标，说明已经找到最左边的目标值
                } else {
                    // 将右边界移动到left，循环结束
                    right = left;
                }
            }
        }
        return (nums[left] == target) ? left : -1;
    }



    public static void main(String[] args) {

//        int [] arr = new int[]{5,5,5,1,2,3,4,5};
        int [] arr = new int[]{2, 3, 5, 7, 7, 7, 8};
        System.out.println(right_bound(arr, 1));
    }
}
