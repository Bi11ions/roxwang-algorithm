package com.roxwang.alogrithms_4th.sort;

import java.util.Arrays;

/**
 * 自顶向下归并排序
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/24 16:54
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        System.out.println("Up2DownMergeSort-初始顺序：" + Arrays.toString(nums));
        sort(nums, 0, nums.length - 1);
    }

    /**
     * 递归实现
     *
     * @param nums
     * @param left
     * @param right
     */
    private void sort(T[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
//        printNums(nums);
    }

    private void printNums(T[] nums) {
        if (null == nums || nums.length < 1) {
            return;
        }

        for (T num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
