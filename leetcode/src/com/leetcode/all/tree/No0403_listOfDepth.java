package com.leetcode.all.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 16:48
 */
public class No0403_listOfDepth {
    /**
     * 1.求出二叉树的深度并创建链表数组
     * 2.层序遍历二叉树
     * 3.在每一层中创建链表
     * 4.保存结果并输出
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (null == tree) {
            return new ListNode[0];
        }

        int depth = getDepth(tree);
        ListNode[] result = new ListNode[depth];
        int depthIndex = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode nodeHead = new ListNode(0);
            ListNode temp = nodeHead;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.next = new ListNode(node.val);
                temp = temp.next;
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result[depthIndex++] = nodeHead.next;
        }

        return result;
    }

    public int getDepth(TreeNode x) {
        if (null == x) {
            return 0;
        }

        return Math.max(getDepth(x.left), getDepth(x.right)) + 1;
    }

    public static void main(String[] args) {
        No0403_listOfDepth no0403_listOfDepth = new No0403_listOfDepth();
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{1, 2, 3, 4, 5, null, 7, 8});
        ListNode[] listNodes = no0403_listOfDepth.listOfDepth(treeNode);
        System.out.println(listNodes);
    }
}
