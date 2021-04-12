package com.leetcode.all.tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * 4
 * /  \
 * 2    7
 * / \ / \
 * 1  3 6  9
 * 镜像输出：
 * 4
 * /  \
 * 7    2
 * / \ / \
 * 9  6 3  1
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/13 15:03
 */
public class No27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        if (null == root.left && null == root.right) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    private void translateTree(TreeNode root, TreeNode left, TreeNode right) {
        root.left = right;
        root.right = left;
        if (null != left) {
            translateTree(left, left.left, left.right);
        }

        if (null != right) {
            translateTree(right, right.left, right.right);
        }
    }
}
