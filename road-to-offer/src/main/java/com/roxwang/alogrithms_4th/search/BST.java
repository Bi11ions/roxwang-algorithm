package com.roxwang.alogrithms_4th.search;

import java.util.Objects;

/**
 * 二叉查找树
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/8 16:36
 */
public class BST<Key extends Comparable<Key>, Value> extends BasicBST<Key, Value> {

    public int size() {
        return size(root);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value value) {
        put(root, key, value);
    }

    public Key max() {
        return max(root).key;
    }

    /**
     * 如果根结点的左链接为空，那么一棵二叉查找
     * 树中最小的键就是根结点；
     * 如果左链接非空，那么树中的最小键就是左子树中的最小键。
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * 如果给定的键 key 小于二叉查找树的根结点的键，那么小于等于 key 的
     * 最大键 floor(key) 一定在根结点的左子树中；
     * <p>
     * 如果给定的键 key 大于二叉查找树的根结点，那么只有当根结点右子树中
     * 存在小于等于 key 的结点时，小于等于 key 的最大键才会出现在右子树中；
     * <p>
     * 否则根结点就是小于等于 key的最大键。
     *
     * @return
     */
    public Key floor(Key key) {
        Node floor = floor(root, key);
        return Objects.isNull(floor) ? null : floor.key;
    }



    /**
     * 如果给定的键 key 小于二叉查找树的根结点，那么只有当根结点左子树中
     * 存在大于等于 key 的结点时，大于等于 key 的最小键才会出现在左子树中；
     * <p>
     * 如果给定的键 key 大于二叉查找树的根结点的键，那么大于等于 key 的
     * 最小键 ceiling(key) 一定在根结点的右子树中；
     * <p>
     * 否则根结点就是大于等于 key的最小键。
     *
     * @return
     */
    public Key ceiling(Key key) {
        Node ceiling = ceiling(root, key);
        return Objects.isNull(ceiling) ? null : ceiling.key;
    }



    public Key select(int k) {
        return select(root, k).key;
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

    public int rank(Key key) {
        return rank(root, key);
    }



    public Node delete(Key key) {
        return delete(root, key);
    }



    public Node deleteMin() {
        return deleteMin(root);
    }


    public Node deleteMax() {
        return deleteMax(root);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }
}
