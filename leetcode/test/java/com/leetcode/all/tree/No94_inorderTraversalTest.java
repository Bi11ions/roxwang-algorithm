package com.leetcode.all.tree;

import org.junit.Test;

import java.util.List;

public class No94_inorderTraversalTest {

    @Test
    public void inorderTraversal() {
        No94_inorderTraversal No94 = new No94_inorderTraversal();
        // 应该为 1, null, 2, null, null, 3
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{1, null, 2, 3});
        List<Integer> list = No94.inorderTraversal(treeNode);
        System.out.println(list.toString());
    }
}