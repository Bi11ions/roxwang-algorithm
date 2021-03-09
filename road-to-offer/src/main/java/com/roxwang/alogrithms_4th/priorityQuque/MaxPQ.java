package com.roxwang.alogrithms_4th.priorityQuque;

/**
 * 优先队列最重要的操作就是删除最大元素和插入元素，所以我们会把精力集中在它们身上。
 * 删除最大元素的方法名为 delMax()，
 * 插入元素的方法名为 insert()。
 * 按照惯例，我们只会通过辅助函数 less() 来比较两个元素，和排序算法一样。如果允许重复元素，最大表示的是所有最大元素之一。
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/4 17:45
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     * 基于堆的完全二叉树
     */
    private Key[] pq;

    /**
     * 存储与 pq[1..N] 中，pq[0] 没有使用
     */
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // 从根节点得到最大元素
        exch(1, N--); // 将其和最后一个节点交换
        pq[N + 1] = null; // 防止对象有利
        sink(1); // 恢复堆的有序性
        return max;
    }

    protected boolean less(int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }

    protected void exch(int sourceIndex, int targetIndex) {
        Key t = pq[sourceIndex];
        pq[sourceIndex] = pq[targetIndex];
        pq[targetIndex] = t;
    }

    /**
     * 由下至上的对有序化（上浮） 的实现
     *
     * @param k 目标上浮节点的位置
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下的堆有序化（下沉）的实现
     *
     * @param k 目标下沉节点的位置
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }
}
