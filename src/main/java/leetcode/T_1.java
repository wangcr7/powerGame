package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: T_1 两数之和
 * @Package: leetcode
 * @Description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * @Author: wangchi
 * @Date: 2022/8/28 - 3:07 PM
 */
public class T_1 {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hash表遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);

        }
        return new int[0];
    }

    public static void main(String[] args) {
//        System.out.printf("aaa");

    }
}
