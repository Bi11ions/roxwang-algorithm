package com.leetcode.all.tree;

import org.junit.Test;

public class No54_kthLargestTest {

    @Test
    public void kthLargest() {
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        No54_kthLargest no54 = new No54_kthLargest();
        int value = no54.kthLargest(treeNode, 3);
        System.out.println(value);
    }
}