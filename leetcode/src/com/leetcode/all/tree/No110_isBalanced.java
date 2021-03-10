package com.leetcode.all.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 平衡:
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 3
 * / \
 * 9    20
 * / \
 * 15   7
 * 不平衡：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 15:36
 */
public class No110_isBalanced {
    /**
     * 只要有某子树不平衡,则该树就不平衡
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 此时如果根节点的左右深度之差的返回值不为-1,即为正确的
        return recur(root) != -1;
    }

    public int recur(TreeNode x) {
        if (null == x) {
            return 0;
        }

        //返回左(右)子树的深度,如果其深度为-1(默认不平衡),则全树不平衡
        int hl = recur(x.left);
        if (-1 == hl) {
            return -1;
        }


        int hr = recur(x.right);
        if (-1 == hr) {
            return -1;
        }

        // 如果子树平衡(也就是相应的深度之差的绝对值小于2),则返回该子树的深度用于和他的兄弟子树比较深度之差
        return Math.abs(hl - hr) < 2 ? Math.max(hl, hr) + 1 : -1;
    }

}
