package com.roxwang.alogrithms_4th.search;

import com.roxwang.alogrithms_4th.basic.Queue;

import java.util.Objects;

/**
 * 基础版 BST，存放公共方法
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/9 17:04
 */
public class BasicBST<Key extends Comparable<Key>, Value> {
    protected Node root; // 根节点

    /**
     * 非递归实现
     *
     * @param key
     * @return
     */
    public Value getNoRecursive(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (0 == cmp) {
                return x.value;
            }

            if (0 > cmp) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        return null;
    }

    /**
     * 递归实现
     *
     * @param x
     * @param key
     * @return
     */
    public Value get(Node x, Key key) {
        // 在以 x 为根节点的子树中查找并返回 key 对应的值
        // 如果找不到则返回 null
        if (Objects.isNull(x)) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }

        if (cmp > 0) {
            return get(x.right, key);
        }

        return x.value;
    }

    public Node put(Node x, Key key, Value value) {
        if (Objects.isNull(x)) {
            return new Node(key, value, 1);
        }

        // 如果 key 存在于以 x 为根节点的子树中，则更新它的值
        // 否则将以 key 与 value 作为键值对创建新的节点插入到该子树中
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public Node max(Node x) {
        if (Objects.isNull(x.right)) {
            return x;
        }

        return max(x.right);
    }

    public Node min(Node x) {
        if (Objects.isNull(x.left)) {
            return x;
        }

        return min(x.left);
    }

    public Node floor(Node x, Key key) {
        if (Objects.isNull(x)) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            return floor(x.left, key);
        }

        Node floor = floor(x.right, key);
        return Objects.isNull(floor) ? x : floor;
    }

    public Node ceiling(Node x, Key key) {
        if (Objects.isNull(key)) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }

        if (cmp > 0) {
            return ceiling(x.right, key);
        }

        Node ceiling = ceiling(x.left, key);
        return Objects.isNull(ceiling) ? x : ceiling;
    }

    public int rank(Node x, Key key) {
        if (Objects.isNull(x)) {
            return 0;
        }

        // 返回以 x 为根节点的自述中小于 x.key 的键的数量
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        }

        if (cmp > 0) {
            // 左子树 + 自身
            return rank(x.right, key) + size(x.left) + 1;
        }

        return size(x.left);
    }

    /**
     * 在删除结点 x 后用它的后继结点填补它的位置。
     * 1. 将指向即将被删除的结点的链接保存为 t；
     * 2. 将 x 指向它的后继结点 min(t.right)；
     * 3. 将 x 的右链接（原本指向一棵所有结点都大于 x.key 的二叉查找树）指向 deleteMin(t.right)，
     * 也就是在删除后所有结点仍然都大于 x.key 的子二叉查找树；
     * 4. 将 x 的左链接（本为空）设为 t.left（其下所有的键都小于被删除的结点和它的后继结点）。
     *
     * @param x
     * @param key
     * @return
     */
    public Node delete(Node x, Key key) {
        if (Objects.isNull(x)) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (Objects.isNull(x.right)) {
                return x.left;
            }

            if (Objects.isNull(x.left)) {
                return x.right;
            }

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    /**
     * 我们要不断深入根结点的左子树中直至遇见一个空链接，
     * 然后将指向该结点的链接指向该结点的右子树
     * （只需要在递归调用中返回它的右链接即可）。
     *
     * @param x
     * @return
     */
    public Node deleteMin(Node x) {
        if (Objects.isNull(x.left)) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Node deleteMax(Node x) {
        if (Objects.isNull(x.right)) {
            return x.left;
        }

        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (Objects.isNull(x)) {
            return;
        }

        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) {
            keys(x.left, queue, lo, hi);
        } else if (cmpLo <= 0 && cmpHi >= 0) {
            queue.enqueue(x.key);
        } else if (cmpHi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }


    /**
     * 想找到排名为k的节点:
     * 如果左子树中的结点数t大于k，
     * 那么我们就继续（递归地）在左子树中查找排名为 k 的键；
     * 如果 t 等于 k，我们就返回根结点中的键；
     * 如果 t 小于 k，我们就（递归地）在右子树中查找排名为（k-t-1）的键。
     *
     * @param x
     * @param k
     * @return
     */
    public Node select(Node x, int k) {
        if (Objects.isNull(x)) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        }

        if (t < k) {
            return select(x.right, k - t - 1);
        }

        return x;
    }

    public int size(Node x) {
        return Objects.isNull(x) ? 0 : x.N;
    }

    public boolean isNotEmpty() {
        return size(root) != 0;
    }

    protected class Node {
        protected Key key; // 键
        protected Value value; // 值
        protected Node left; // 左子树
        protected Node right; // 右子树
        protected int N; // 以该节点为根节点的子树中的节点总数
        protected boolean color;

        public Node() {
        }

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
}
