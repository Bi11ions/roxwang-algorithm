package com.leetcode.all.tree;

/**
 * 814. 二叉树剪枝
 * 给定二叉树根结点root，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * 示例1:
 * 输入: [1,null,0,null,null,0,1]
 * 输出: [1,null,0,null,1]
 * <p>
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * 1         1
 * \         \
 * 0   ->    0
 * / \         \
 * 0   1         1
 * <p>
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * 1           1
 * / \           \
 * 0   1    ->     1
 * / \   / \          \
 * 0   0 0   1          1
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/29 17:29
 */
public class No814_pruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (null == root.left && null == root.right && 0 == root.val) {
            return null;
        }

        return root;
    }
}
