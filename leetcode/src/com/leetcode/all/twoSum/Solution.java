package com.leetcode.all.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author wangsen@qgutech.com
 * @since 2019/3/24 9:06
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

//    public static int[] twoSum(int[] nums, int target) {
//        if (null == nums || nums.length < 1) {
//            return new int[]{0};
//        }
//
//        int[] resultIndex = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            resultIndex[0] = i;
//            int header = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                resultIndex[1] = j;
//                int footer = nums[j];
//                if (header + footer == target) {
//                    return resultIndex;
//                }
//            }
//        }
//
//        return resultIndex;
//    }

    public static int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return new int[]{0};
        }

        int[] resultIndex = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (map.get(target - temp) == null) {
                map.put(temp, i);
            } else {
                resultIndex[0] = map.get(target - temp);
                resultIndex[1] = i;
            }
        }

        return resultIndex;
    }
}
