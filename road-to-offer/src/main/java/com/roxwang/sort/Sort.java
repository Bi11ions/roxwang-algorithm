package com.roxwang.sort;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/23 10:16
 */
public abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] nums, int sourceIndex, int targetIndex) {
        T t = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = t;
    }
}
