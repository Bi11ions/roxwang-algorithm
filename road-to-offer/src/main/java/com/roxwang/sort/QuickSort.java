package com.roxwang.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 * 快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，
 * 将这两个子数组排序也就将整个数组排序了。
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/24 22:09
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    public void sort(T[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int j = partition(nums, left, right);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    /**
     * 切分
     * 取 nums[left] 作为切分元素，
     * 然后从数组的左端向右扫描直到找到第一个大于等于它的元素，
     * 再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，
     * 右指针 j 的右侧元素都不小于切分元素。当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     */
    private int partition(T[] nums, int left, int right) {
        int i = left, j = right + 1;
        T v = nums[left];
        while (true) {
            while (less(nums[++i], v) && i != right) ;
            while (less(v, nums[--j]) && j != left) ;
            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }

        swap(nums, left, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}
