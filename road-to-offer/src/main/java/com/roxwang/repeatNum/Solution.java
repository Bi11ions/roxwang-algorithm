package com.roxwang.repeatNum;

import com.roxwang.uitls.ArrayUtil;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/16 14:45
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        int repeatNum = getRepeatInRandom(nums);
        System.out.println(repeatNum);
    }

    private static int getRepeatInRandom(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                // 如果交换位置上的值，已经于该值相等，说明已经有一个该值了
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                ArrayUtil.swap(nums[i], nums[nums[i]], nums);
            }
        }

        return 0;
    }
}

