package com.roxwang.sort;

/**
 * 希尔排序（缩小增量排序）
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/24 10:24
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (null == nums || nums.length < 1) {
            return;
        }

        int length = nums.length;
        // 增量
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40...
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
