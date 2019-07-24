package com.roxwang.repeatNumTwo;

/**
 * 不修改原数组的情况下，找出重复的数字
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/21 23:07
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int repeatNum = getRepeatNumInOriginArray(nums);
        System.out.println(repeatNum);
    }

    public static int getRepeatNumInOriginArray(int[] nums) {
        if (null == nums || nums.length < 1) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                }

                break;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] nums, int start, int end) {
        if (null == nums || nums.length < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                ++count;
            }
        }

        return count;
    }
}
