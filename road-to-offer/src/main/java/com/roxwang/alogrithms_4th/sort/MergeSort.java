package com.roxwang.alogrithms_4th.sort;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/24 11:05
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    // 辅助数组
    protected T[] aux;

    protected void merge(T[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        // 将数组复制到辅助数组上
        for (int k = left; k <= right; k++) {
            aux[k] = nums[k];
        }

        for (int k = left; k <= right; k++) {
            if (i > mid) { // 左半边用完时，直接取右半边的数据
                nums[k] = aux[j++];
            } else if (j > right) { // 右半边用完时，直接取左半边数据
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) { //相邻两个节点比较大小，小于的赋值，否则大于的赋值
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }

            printNums(nums);
            System.out.println("========>");
        }
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
