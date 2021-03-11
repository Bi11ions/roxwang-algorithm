package com.leetcode.all.tree;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 * 输入：root = [1]
 * 输出：1
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 17:41
 */
public class No222_countNodes {
    /**
     * 常规递归解法
     *
     * @param root
     * @return
     */
//    public int countNodes(TreeNode root) {
//        if (null == root) {
//            return 0;
//        }
//
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }

    /**
     * 根据二叉树性质解法
     * <p>
     * 如果满二叉树的层数为h，则总节点数为：2^h - 1.
     * 那么我们来对 root 节点的左右子树进行高度统计，分别记为 left 和 right，有以下两种结果：
     * left == right。
     * 这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
     * 所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，
     * 则正好是 2^left。再对右子树进行递归统计。
     * left != right。
     * 说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
     * 同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    /**
     * 对于完全二叉树，可以利用其性质，不适用递归方法计算层数。
     * 常规递归方法计算层数
     * public int getDepth(TreeNode x) {
     * if (null == x) {
     * return 0;
     * }
     * <p>
     * return Math.max(getDepth(x.left), getDepth(x.right)) + 1;
     * }
     *
     * @param root
     * @return
     */
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }

        return level;
    }
}
