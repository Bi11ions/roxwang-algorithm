package com.leetcode.all.tree;

import org.junit.Test;

public class No222_countNodesTest {

    @Test
    public void countNodes() {
        No222_countNodes no222 = new No222_countNodes();
        int count = no222.countNodes(TreeNode.buildTreeNode(new Integer[]{1, 2, 3, 4, 5, 6}));
        System.out.println(count);
    }
}