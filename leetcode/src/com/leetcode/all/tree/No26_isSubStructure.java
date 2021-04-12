package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/13 14:15
 */
public class No26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }

        boolean result = false;
        // 1.先找出来与 B 根节点相同的 A 的子节点，
        if (A.val == B.val) {
            result = checkSubTree(A, B);
        }

        // 2.再逐步判断 B 的子树与 A 的子节点的子树是否相同
        if (!result) {
            result = isSubStructure(A.left, B);
        }

        if (!result) {
            result = isSubStructure(A.right, B);
        }

        return result;
    }

    private boolean checkSubTree(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }

        if (null == A) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return checkSubTree(A.left, B.left) && checkSubTree(A.right, B.right);
    }

    private List<TreeNode> getSameRootNode(TreeNode A, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> resultList = new ArrayList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == val) {
                    resultList.add(node);
                }

                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }

        return resultList;
    }
}