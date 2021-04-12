package com.leetcode.all.tree;

import org.junit.Test;

import java.util.Arrays;

public class No27_mirrorTreeTest {

    @Test
    public void mirrorTree() {
        No27_mirrorTree no27 = new No27_mirrorTree();
        TreeNode node = no27.mirrorTree(TreeNode.buildTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
        System.out.println(Arrays.toString(TreeNode.toArrays(node)));
    }
}