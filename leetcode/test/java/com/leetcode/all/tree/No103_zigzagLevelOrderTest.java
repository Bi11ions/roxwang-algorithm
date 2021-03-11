package com.leetcode.all.tree;

import org.junit.Test;

import java.util.List;

public class No103_zigzagLevelOrderTest {

    @Test
    public void zigzagLevelOrder() {
        No103_zigzagLevelOrder no103 = new No103_zigzagLevelOrder();
        List<List<Integer>> lists = no103.zigzagLevelOrder(TreeNode.buildTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5}));
        System.out.println(lists.toString());
    }
}