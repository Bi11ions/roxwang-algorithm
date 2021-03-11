package com.leetcode.all.tree;

import org.junit.Test;

import java.util.Arrays;

public class No998_insertIntoMaxTreeTest {

    @Test
    public void insertIntoMaxTree() {
        No998_insertIntoMaxTree No998 = new No998_insertIntoMaxTree();
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{4, 1, 3, null, null, 2});
        TreeNode addedTreeNode = No998.insertIntoMaxTree(treeNode, 5);
        System.out.println(Arrays.toString(TreeNode.toArrays(addedTreeNode)));
    }
}