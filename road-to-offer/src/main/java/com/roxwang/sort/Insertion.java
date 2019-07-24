package com.roxwang.sort;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/23 18:57
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        if (null == nums || nums.length < 1) {
            return;
        }

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
}
