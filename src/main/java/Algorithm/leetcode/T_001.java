package Algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: CristianoRonaldo
 * @description: 两数字之和
 *
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *

 * @author: wang chi
 * @create: 2020-06-30 10:39
 */
public class T_001 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {hashMap.get(target - nums[i]),i};

            }
            hashMap.put(nums[i], i);
        }
        return null;

    }
}
