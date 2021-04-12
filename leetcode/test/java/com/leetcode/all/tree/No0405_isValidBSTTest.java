package com.leetcode.all.tree;

import org.junit.Test;

public class No0405_isValidBSTTest {

    @Test
    public void isValidBST() {
        No0405_isValidBST no0405 = new No0405_isValidBST();
        TreeNode node = TreeNode.buildTreeNode(new Integer[]{1, 1});
        System.out.println(no0405.isValidBST(node));
    }
}