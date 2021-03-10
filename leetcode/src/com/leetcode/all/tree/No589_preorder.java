package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/10 17:41
 */
public class No589_preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> rootList = new ArrayList<>();
        dfs(rootList, root);
        return rootList;
    }

    /**
     * 递归调用法
     *
     * @param list
     * @param root
     */
    public void dfs(List<Integer> list, Node root) {
        if (null != root) {
            list.add(root.val);
            List<Node> children = root.children;
            for (Node node : children) {
                dfs(list, node);
            }
        }
    }

    /**
     * 我们使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点
     * 我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。
     * 随后每次我们从栈顶取出一个节点 u，它是我们当前遍历到的节点，并把 u 的所有子节点逆序推入栈中。
     * 例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1，
     * 这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
     *
     * @param root
     * @return
     */
    public List<Integer> iterate(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (null == root) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            if (null == node.children) {
                continue;
            }

            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }

        return output;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
