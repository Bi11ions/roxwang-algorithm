package com.leetcode.all.tree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 15:00
 */
public class No54_kthLargest {
    private int result;
    private int k;


    /**
     * 使用逆中序的方法.
     * 时间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N ，占用 O(N) 时间。
     * 空间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }

        this.k = k;
        postOrder(root);
        return result;
    }

    private void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        // 因为列表需要从大到小排列，所以先找右孩子节点， 左孩子 < 根节点 < 右孩子
        postOrder(root.right);
        if (this.k == 0) {
            return;
        }

        // 每次判断都减少一次，直到第 k 个，赋值即可
        if (--this.k == 0) {
            this.result = root.val;
        }

        postOrder(root.left);
    }
}
