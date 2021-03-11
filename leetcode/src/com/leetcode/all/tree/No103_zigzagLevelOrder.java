package com.leetcode.all.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 17:03
 */
public class No103_zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reverse) {
                    subList.offerLast(node.val);
                } else {
                    subList.offerFirst(node.val);
                }

                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }

            resultList.add(new ArrayList<>(subList));
            reverse = !reverse;
        }

        return resultList;
    }
}
