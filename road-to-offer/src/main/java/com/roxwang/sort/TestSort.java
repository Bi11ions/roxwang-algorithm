package com.roxwang.sort;

import org.junit.Test;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/23 10:39
 */
public class TestSort {
    private Integer[] nums = {5, 3, 6, 2, 4, 1};

    @Test
    public void testSelection() {
        Selection<Integer> selectionSort = new Selection<>();
        selectionSort.sort(nums);
        printNums(nums);
    }

    @Test
    public void testBubble() {
        Bubble<Integer> bubbleSort = new Bubble<>();
        bubbleSort.sort(nums);
        printNums(nums);
    }

    @Test
    public void testInsertion() {
        Insertion<Integer> integerInsertion = new Insertion<>();
        integerInsertion.sort(nums);
        printNums(nums);
    }

    @Test
    public void testShell() {
        Shell<Integer> shell = new Shell<>();
        shell.sort(nums);
        printNums(nums);
    }

    @Test
    public void testUp2DownMergeSort() {
        Up2DownMergeSort<Integer> up2DownMergeSort = new Up2DownMergeSort<>();
        up2DownMergeSort.sort(nums);
//        printNums(nums);
    }

    @Test
    public void testDown2UpMergeSort() {
        Down2UpMergeSort<Integer> down2UpMergeSort = new Down2UpMergeSort<>();
        down2UpMergeSort.sort(nums);
    }

    @Test
    public void testQuickSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(nums);
        printNums(nums);
    }

    private void printNums(Integer[] nums) {
        if (null == nums || nums.length < 1) {
            return;
        }

        for (Integer num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
