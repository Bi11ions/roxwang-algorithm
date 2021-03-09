package com.roxwang.alogrithms_4th.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quick3way<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        T v = nums[lo];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }

        // nums[lo...lt-1] < v = num[lt...gt] < a[gt+1...hi] 成立
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}
