package com.leetcode.all.tree;

import org.junit.Test;

import java.util.Arrays;

public class No814_pruneTreeTest {

    @Test
    public void pruneTree() {
        No814_pruneTree no814 = new No814_pruneTree();
        TreeNode node = TreeNode.buildTreeNode(new Integer[]{1, null, 0, null, null, 0, 1});
        node = no814.pruneTree(node);
        System.out.println(Arrays.toString(TreeNode.toArrays(node)));
    }
}