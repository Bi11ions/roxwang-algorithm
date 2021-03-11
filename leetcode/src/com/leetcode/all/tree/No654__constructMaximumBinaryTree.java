package com.leetcode.all.tree;

/**
 * 构建最大树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 10:34
 */
public class No654__constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || 1 > nums.length) {
            return null;
        }

        return buildMaximumTreeNode(nums, 0, nums.length - 1);
    }

    private TreeNode buildMaximumTreeNode(int[] nums, int start, int end) {
        int maxIndex = -1;
        int maxVal = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
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
}
