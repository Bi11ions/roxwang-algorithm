package com.leetcode.all.tree;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

public class No34_pathSumTest {

    @Test
    public void pathSum() {
        No34_pathSum no34 = new No34_pathSum();
        TreeNode node = TreeNode.buildTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        List<List<Integer>> lists = no34.pathSum(node, 22);
        System.out.println(new Gson().toJson(lists));
    }
}