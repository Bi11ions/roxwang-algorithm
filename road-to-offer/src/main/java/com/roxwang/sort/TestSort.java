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

    private void printNums(Integer[] nums) {
        if (null == nums || nums.length < 1) {
            return;
        }

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
