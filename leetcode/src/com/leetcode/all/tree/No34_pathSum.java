package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * 返回:[
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/13 17:09
 */
public class No34_pathSum {
    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (null == root) {
            return new ArrayList<>(0);
        }

        helper(root, target);
        return resultList;
    }

    private void helper(TreeNode root, int target) {
        if (null == root) {
            return;
        }

        path.add(root.val);
        target -= root.val;
        // 若最后为0，且为叶子节点直接加入链路即可
        if (0 == target && null == root.left && null == root.right) {
            resultList.add(new LinkedList<>(path));
        }

        // 否则先向左子树遍历，再像右子树遍历
        helper(root.left, target);
        helper(root.right, target);
        // 当最后到叶子节点时，逐层清除 path 中得数据
        path.removeLast();
    }
}
