package com.leetcode.all.tree;

import org.junit.Test;

public class No26_isSubStructureTest {

    @Test
    public void isSubStructure() {
        No26_isSubStructure no26 = new No26_isSubStructure();
//        boolean subStructure = no26.isSubStructure(TreeNode.buildTreeNode(new Integer[]{3, 4, 5, 1, 2}),
//                TreeNode.buildTreeNode(new Integer[]{4, 1}));
        boolean subStructure = no26.isSubStructure(TreeNode.buildTreeNode(new Integer[]{1, 2, 3}),
                TreeNode.buildTreeNode(new Integer[]{3, 1}));
        System.out.println(subStructure);
    }

    @Test
    public void testInt() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}