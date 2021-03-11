package com.leetcode.all.tree;

import java.util.List;

/**
 * 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
 * 给定一个值，插入最大数中，保证插入后还是有序的：
 * - 如果A为空，返回null
 * - 否则，令A[i]作为 A 的最大元素。创建一个值为A[i]的根节点 root
 * - root的左子树将被构建为Construct([A[0], A[1], ..., A[i-1]])
 * root的右子树将被构建为 Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
 * - 返回 root
 * 请注意，我们没有直接给定A，只有一个根节点root = Construct(A).
 * <p>
 * 假设 B 是 A 的副本，并在末尾附加值 val。题目数据保证 B中的值是不同的。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 11:31
 */
public class No998_insertIntoMaxTree {
    /**
     * 最佳解法
     * 将val值放在数组的最后面。
     * 判断逻辑为
     * - 如果是最大数，则将root放在左边
     * - 否则一直是在右子树递归  <<由最大树的定义决定，在root中的最大值右侧的是右子树的元素>>
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        TreeNode right = insertIntoMaxTree(root.right, val);
        root.right = right;
        return root;
    }

    /**
     * 自己的解法
     */
//    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
//        if (null == root) {
//            return null;
//        }
//
//        List<Integer> nums = new ArrayList<>();
//        // 先用中序遍历还原数组
//        toList(root, nums);
//        // 再将 val 放入数组最后
//        nums.add(val);
//        // 再根据新数组构建最大数
//        return buildMaximumTreeNode(nums, 0, nums.size() - 1);
//    }
    private TreeNode buildMaximumTreeNode(List<Integer> nums, int start, int end) {
        int maxIndex = -1;
        int maxVal = -1;
        for (int i = start; i <= end; i++) {
            if (nums.get(i) > maxVal) {
                maxIndex = i;
                maxVal = nums.get(i);
            }
        }

        if (maxIndex == -1) {
            return null;
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = buildMaximumTreeNode(nums, start, maxIndex - 1);
        root.right = buildMaximumTreeNode(nums, maxIndex + 1, end);
        return root;
    }

    public void toList(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        toList(root.left, list);
        list.add(root.val);
        toList(root.right, list);
    }
}
