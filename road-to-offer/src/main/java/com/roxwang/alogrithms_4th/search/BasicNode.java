package com.roxwang.alogrithms_4th.search;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/9 17:26
 */
public class BasicNode<Key extends Comparable<Key>, Value> {
    protected Key key; // 键
    protected Value value; // 值
    protected BasicNode<Key, Value> left; // 左子树
    protected BasicNode<Key, Value> right; // 右子树
    protected int N; // 以该节点为根节点的子树中的节点总数

    public BasicNode() {
    }

    public BasicNode(Key key, Value value, int N) {
        this.key = key;
        this.value = value;
        this.N = N;
    }
}
