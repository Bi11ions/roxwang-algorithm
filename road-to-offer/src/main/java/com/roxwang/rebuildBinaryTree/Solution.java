package com.roxwang.rebuildBinaryTree;

import com.roxwang.Model.TreeNode;
import com.roxwang.uitls.ArrayUtil;
import org.junit.Test;

/**
 * 7 重建二叉树
 * 题目描述
 * 输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
 * 样例:
 * 给定：
 * 前序遍历是：[3, 9, 20, 15, 7]
 * 中序遍历是：[9, 3, 15, 20, 7]
 * <p>
 * 返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
 * 返回的二叉树如下所示：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 注意:
 * 二叉树中每个节点的值都互不相同；
 * 输入的前序遍历和中序遍历一定合法；
 */
public class Solution {
    @Test
    public void testPreAndInOrder() {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6 ,8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8 ,6};
        TreeNode tree = buildTreeByPreAnInOrder(preOrder, inOrder);
        tree.printByLevelOrder();
    }

    /**
     *
     * 二叉树的三种遍历方式：
     *      前序遍历：根结点 —> 左子树 —> 右子树（先遍历根节点，然后左右）
     *      中序遍历：左子树—> 根结点 —> 右子树（在中间遍历根节点）
     *      后序遍历：左子树 —> 右子树 —> 根结点（最后遍历根节点）
     * 所谓的前序、中序、后续，就是对根节点而言的，左右的遍历顺序不变，前序就是根节点最先遍历，
     * 然后左右；中序就是把根节点放在中间遍历；后序则是把根节点放在最后遍历。
     */
    /**
     * 根据前序遍历与中序遍历重建一个二叉树
     *
     * @param preOrder int[] 前序遍历数组
     * @param inOrder int[] 中序遍历数组
     * @return TreeNode 树结构. 当传输入数据非法时会返回 null
     */
    public TreeNode buildTreeByPreAnInOrder(int[] preOrder, int[] inOrder) {
        if (null == preOrder || null == inOrder || !ArrayUtil.simpleEqual(preOrder, inOrder)) {
            return null;
        }

        return buildByPreAnIn(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    /**
     * 递归函数。 当找到前序遍历的根节点与在中序遍历中的位置时返回
     *
     * @param preOrderArr 前序遍历数组
     * @param inOrderArr 中序遍历数组
     * @param preStart 前序遍历开始索引
     * @param preEnd 前序遍历结束索引
     * @param inStart 中序遍历开始索引
     * @param inEnd 中序遍历结束索引
     * @return 树
     */
    private TreeNode buildByPreAnIn(int[] preOrderArr, int[] inOrderArr, int preStart, int preEnd, int inStart, int inEnd) {
        int rootValue = preOrderArr[preStart];
        TreeNode root = new TreeNode(rootValue);
        // 当前序遍历的第一个节点与中序遍历的第一个节点相同，则说明该节点是改子树的根节点
        if (preStart == preEnd) {
            return root;
        }

        // 左子树偏移量 在中序遍历中 0 - offset 左子树
        int offset = 0;
        // 中序遍历开始位置，也就是右子树的开始位置
        int indexOfInArr = inStart;
        for (; indexOfInArr <= inEnd; indexOfInArr++) {
            if (rootValue == inOrderArr[indexOfInArr]) {
                break;
            }

            ++offset;
        }

        // 如果偏移量没有增加，说明左子树为空
        root.setLeft(offset > 0 ?
                buildByPreAnIn(preOrderArr, inOrderArr, preStart + 1, preStart + offset, inStart, indexOfInArr - 1) : null);
        // 如果中序遍历的开始为小于结束位置，那么继续遍历，否则右子树为0
        root.setRight(indexOfInArr < inEnd ?
                buildByPreAnIn(preOrderArr, inOrderArr, preStart + offset + 1, preEnd, indexOfInArr + 1, inEnd) : null);
        return root;
    }
}
