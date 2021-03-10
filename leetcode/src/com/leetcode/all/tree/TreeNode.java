package com.leetcode.all.tree;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 15:40
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeNode(Integer[] array) {
        if (null == array || array.length < 1) {
            return null;
        }

        return buildTreeNode(array, 0);
    }

    private static TreeNode buildTreeNode(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length && null != array[index]) {
            root = new TreeNode(array[index]);
            root.left = buildTreeNode(array, index * 2 + 1);
            root.right = buildTreeNode(array, index * 2 + 2);
        }

        return root;
    }
}
