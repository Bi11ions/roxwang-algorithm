package com.leetcode.all.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * 返回树中 好叶子节点对的数量 。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/11 15:30
 */
public class No1530_countPairs {
    private int res = 0;

    public int countPairs(TreeNode root, int distance) {
        if (null == root || distance < 1) {
            return 0;
        }

        dfs(root, distance);
        return res;
    }

    /**
     * 抽象为每个子节点到自己的距离
     * <p>
     * root->val 没用，父节点和子节点的距离是 11
     * 对树后序遍历 ，需要返回这个节点到其下方所有叶子节点的距离
     * 这样就可以将这个节点的左子树所有叶子节点和右子树所有叶子节点都凑个对
     * 然后将所有叶子节点不超过距离的弄到一起返回
     *
     * @return
     */
    private List<Integer> dfs(TreeNode root, int distance) {
        // dfs 返回当前父节点下所有叶子节点到本父节点的路径长度, 向量中的每一个路径长度对应一个叶子节点
        List<Integer> list = new ArrayList<>();
        // root为空返回空向量
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(1);
            return list;
        }

        //遍历左子树获得左侧叶子节点到本节点路径长度;
        List<Integer> left = dfs(root.left, distance);
        for (Integer item : left) {
            if (++item > distance) continue;
            list.add(item);
        }

        //遍历右子树获得右侧叶子节点到本节点路径长度;
        List<Integer> right = dfs(root.right, distance);
        for (Integer item : right) {
            if (++item > distance) continue;
            list.add(item);
        }

        //左右子树叶子节点两两配对， 二者之和就是两个叶子节点之间的路径长度    <=distance ans++
        for (Integer leftItem : left) {
            for (Integer rightItem : right) {
                res += (leftItem + rightItem) <= distance ? 1 : 0;
            }
        }

        return list;
    }
}
