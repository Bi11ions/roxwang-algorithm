package com.roxwang.alogrithms_4th.search;


import java.util.Objects;

/**
 * 红黑树
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/9 14:58
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> extends BasicBST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);
        if (isNotEmpty()) {
            root.color = BLACK;
        }
    }

    @Override
    public Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }

            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }

            if (0 == key.compareTo(h.key) && (null == h.right)) {
                return null;
            }

            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }

            if (0 == key.compareTo(h.key)) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }

        return balance(h);
    }

    private Node moveRedRight(Node h) {
        // 假设结点 h 为红色，h.right 和 h.right.left 都是黑色，
        // 将 h.right 或者 h.right 的子结点之一变红
        flipColors(h);
        if (!isRed(h.right.left)) {
            h = rotateRight(h.right);
        }

        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMax(root);
        if (isNotEmpty()) {
            root.color = BLACK;
        }
    }

    @Override
    public Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (Objects.isNull(h.right)) {
            return null;
        }

        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        // 假设节点 h 为红色，h.left 和 h.left.left 都是黑色
        // 将 h.left 或者 h.left 的子节点之一变红
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }

        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);
        if (isNotEmpty()) {
            root.color = BLACK;
        }
    }

    @Override
    public Node deleteMin(Node h) {
        if (Objects.isNull(h.left)) {
            return null;
        }

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return balance(h);
    }

    /**
     * 这里的 flipColors() 方法将会补全三条链接的颜色，而不是正文中实现插入操作时实现的flipColors() 方法。
     * 对于删除，我们会将父结点设为 BLACK（黑）而将两个子结点设为 RED（红）。
     *
     * @param h
     * @return
     */
    private Node balance(Node h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }

        // 当右节点是红色，左节点是黑色时，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 当左节点时红色，左节点的左节点也是红色时，进行右旋转（存在两条连续的红链接时）
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 对于删除，我们会将父结点设为 BLACK（黑）而将两个子结点设为 RED（红）。
        if (isRed(h.left) && isRed(h.right)) {
            h.color = BLACK;
            h.left.color = RED;
            h.right.color = RED;
            ;
        }

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public void put(Key key, Value value) {
        // 查找key，找到则更新其值，否则作为一个新节点加入
        root = put(root, key, value);
        root.color = BLACK;
    }

    @Override
    public Node put(Node h, Key key, Value value) {
        if (Objects.isNull(h)) {
            // 标准的插入操作，和父节点用红链接相连
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        // 当右节点是红色，左节点是黑色时，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 当左节点时红色，左节点的左节点也是红色时，进行右旋转（存在两条连续的红链接时）
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 左右都是红链接时，转换颜色，并将红链接向树的上方传递
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    /**
     * 将一个节点的两个红色子节点转为黑色，并将黑色节点转为红色
     *
     * @param h
     */
    public void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 左旋转
     *
     * @param h
     * @return
     */
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.left = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转
     *
     * @param h
     * @return
     */
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.right = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size(Node x) {
        return Objects.isNull(x) ? 0 : x.N;
    }

    private boolean isRed(Node x) {
        return Objects.nonNull(x) && x.color == RED;
    }
}
