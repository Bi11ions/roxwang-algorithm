package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 15:40
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeNode(Integer[] array) {
        if (null == array || array.length < 1) {
            return null;
        }

        return buildTreeNode(array, 0);
    }

    private static TreeNode buildTreeNode(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length && null != array[index]) {
            root = new TreeNode(array[index]);
            root.left = buildTreeNode(array, index * 2 + 1);
            root.right = buildTreeNode(array, index * 2 + 2);
        }

        return root;
    }

    public static Integer[] toArrays(TreeNode root) {
        if (null == root) {
            return new Integer[0];
        }

        int depth = getDepth(root);
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty() && depth > count++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (null == treeNode) {
                    list.add(null);
                    continue;
                }

                list.add(treeNode.val);
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
        }

        return list.toArray(new Integer[0]);
    }

    public static int getDepth(TreeNode x) {
        if (null == x) {
            return 0;
        }

        return Math.max(getDepth(x.left), getDepth(x.right)) + 1;
    }

    /**
     * 需要先确定 list 数组的大小。 否则会报错 IndexOutOfBoundsException
     *
     * @param root
     * @param index
     * @param list
     */
    private static void toArrays(TreeNode root, int index, List<Integer> list) {
        if (null == root) {
            list.add(null);
            return;
        }

        list.set(index, root.val);
        toArrays(root.left, index * 2 + 1, list);
        toArrays(root.right, index * 2 + 2, list);
    }
}
