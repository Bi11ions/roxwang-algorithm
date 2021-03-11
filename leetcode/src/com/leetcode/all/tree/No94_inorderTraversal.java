package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 13:43
 */
public class No94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }


        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
