package com.leetcode.all.tree;

import org.junit.Test;

public class No112_hasPathSumTest {

    @Test
    public void hasPathSum() {
        No112_hasPathSum no112 = new No112_hasPathSum();
        TreeNode node = TreeNode.buildTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(no112.hasPathSum(node, 22));
    }
}