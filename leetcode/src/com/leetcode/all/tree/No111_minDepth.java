package com.leetcode.all.tree;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 16:22
 */
public class No111_minDepth {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
}
