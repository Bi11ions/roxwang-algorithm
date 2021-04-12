package com.leetcode.all.tree;

import org.junit.Test;

public class No28_isSymmetricTest {

    @Test
    public void isSymmetric() {
        No28_isSymmetric no28 = new No28_isSymmetric();
//        boolean symmetric = no28.isSymmetric(TreeNode.buildTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
        boolean symmetric = no28.isSymmetric(TreeNode.buildTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}));
        System.out.println(symmetric);
    }
}