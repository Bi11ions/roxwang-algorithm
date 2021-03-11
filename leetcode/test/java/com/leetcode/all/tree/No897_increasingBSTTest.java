package com.leetcode.all.tree;

import org.junit.Test;

public class No897_increasingBSTTest {

    @Test
    public void increasingBST() {
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        No897_increasingBST no897 = new No897_increasingBST();
        TreeNode newTreeNode = no897.changeLink(treeNode);
        System.out.println(newTreeNode);
    }
}