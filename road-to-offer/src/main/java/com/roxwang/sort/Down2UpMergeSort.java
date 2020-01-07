package com.roxwang.sort;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/24 21:55
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        aux = (T[]) new Comparable[length];

        for (int sz = 1; sz < length; sz++) {
            for (int lo = 0; lo < length - sz; lo++) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }
}
