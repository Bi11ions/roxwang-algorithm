package com.roxwang.alogrithms_4th.sort;

/**
 * 希尔排序（缩小增量排序）
 * <p>
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是
 * 为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 * <p>
 * 希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ... 的希尔排序所需要的比较次数
 * 不会超过 N 的若干倍乘于递增序列的长度。
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
