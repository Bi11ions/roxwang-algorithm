package com.leetcode.all.tree;

import org.junit.Test;

public class No1530_countPairsTest {

    @Test
    public void countPairs() {
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{1, 2, 3, null, 4});
        No1530_countPairs no1530 = new No1530_countPairs();
        int count = no1530.countPairs(treeNode, 3);
        System.out.println(count);
    }
}