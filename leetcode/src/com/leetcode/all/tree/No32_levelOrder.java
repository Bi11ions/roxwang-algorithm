package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如：
 * 给定：[3,9,20,null,null,15,7],
 * 返回：[[3], [9,20], [15,7]]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 17:59
 */
public class No32_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                nodeValues.add(node.val);
                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }

            resultList.add(nodeValues);
        }

        return resultList;
    }

    public static void main(String[] args) {
        No32_levelOrder reuslt = new No32_levelOrder();
        TreeNode treeNode = TreeNode.buildTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> listNodes = reuslt.levelOrder(treeNode);
        System.out.println(listNodes);
    }

}
