package com.leetcode.all.tree;

import org.junit.Test;

import java.util.Arrays;

public class No654__constructMaximumBinaryTreeTest {

    @Test
    public void constructMaximumBinaryTree() {
        No654__constructMaximumBinaryTree No654 = new No654__constructMaximumBinaryTree();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = No654.constructMaximumBinaryTree(nums);
        System.out.println(Arrays.toString(TreeNode.toArrays(treeNode)));
    }
}