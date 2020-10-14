package com.roxwang.Model;

import lombok.Data;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 树结构
 */
@Data
public class TreeNode {
    /**
     * 值
     */
    private int val;

    /**
     * 左节点
     */
    private TreeNode left;

    /**
     * 右节点
     */
    private TreeNode right;

    /**
     * 树的大小
     */
    private int size;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * 层序遍历打印树
     * 1.首先申请一个新的队列，记为queue；
     * 2.将头结点head压入queue中；
     * 3.每次从queue中出队，记为node，然后打印node值，如果node左孩子不为空，则将左孩子入队；如果node的右孩子不为空，则将右孩子入队；
     * 4.重复步骤3，直到queue为空。
     */
    public void printByLevelOrder() {
        TreeNode root = this;
        int size = this.getSize();
        Queue<TreeNode> queue = new ArrayBlockingQueue<>(size);
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + " ");
            if (null != root.left) {
                queue.add(root.left);
            }

            if (null != root.right) {
                queue.add(root.right);
            }
        }
    }

    public int getSize() {
        // 这里使用前序遍历获取 Size
        int size = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = this;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                size++;
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

        return size;
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     * @param node    二叉树节点
     */
    public static void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val+" ");
    }


    /**
     * 二叉树中序遍历   左-> 根-> 右
     * @param node   二叉树节点
     */
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.val+" ");
        inOrderTraversal(node.right);
    }

    /**
     * 二叉树前序遍历   根-> 左-> 右
     * @param node    二叉树节点
     */
    public static void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        System.out.print(node.val+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
