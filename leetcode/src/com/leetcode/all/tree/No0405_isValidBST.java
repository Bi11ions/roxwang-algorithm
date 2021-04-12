package com.leetcode.all.tree;

/**
 * 面试题 04.05. 合法二叉搜索树
 * <p>
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/29 19:16
 */
public class No0405_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (null == root) {
            return true;
        }

        int val = root.val;
        if (null != lower && val <= lower) {
            return false;
        }

        if (null != upper && val >= upper) {
            return false;
        }

        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }
}
