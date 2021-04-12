package com.leetcode.all.tree;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/13 16:23
 */
public class No28_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode A, TreeNode B) {
        if (null == A && null == B) {
            return true;
        }

        if (null == A || null == B) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
    }
}
