package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 13:56
 */
public class No897_increasingBST {

    private TreeNode cur;

    /**
     * 改变树连接的方式
     * 此方法需要一个成员变量，否则引用无法传递
     *
     * @param root
     * @return
     */
    public TreeNode changeLink(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    /**
     * 构造新树的方式
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (null == root) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        transfer(root, list);
        TreeNode newRoot = new TreeNode();
        TreeNode tempRoot = newRoot;
        for (Integer val : list) {
            tempRoot.right = new TreeNode(val);
            tempRoot = tempRoot.right;
        }

        return newRoot.right;
    }

    private void transfer(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        transfer(root.left, list);
        list.add(root.val);
        transfer(root.right, list);
    }
}
