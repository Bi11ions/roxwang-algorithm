package com.roxwang.alogrithms_4th.sort;

import java.util.Arrays;

/**
 * 自底向上排序
 * 平均 lgN 次两两归并
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/24 21:55
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    /**
     * 非递归实现
     *
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        aux = (T[]) new Comparable[length];
        System.out.println("Up2DownMergeSort-初始顺序：" + Arrays.toString(nums));

        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }
}
