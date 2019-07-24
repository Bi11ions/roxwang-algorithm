package com.roxwang.uitls;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/21 23:11
 */
public class ArrayUtil {
    public static void swap(int sourceIndex, int targetIndex, int[] nums) {
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }
}
