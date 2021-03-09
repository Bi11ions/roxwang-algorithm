package com.roxwang.alogrithms_4th.search;

import com.roxwang.alogrithms_4th.basic.Queue;

/**
 * 二分查找（基于有序数组）
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/6 14:22
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N; // 当前数组实际大小

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }

        return null;
    }

    public void put(Key key, Value value) {
        // 检查是否需要扩容
        if (N == keys.length) {
            resize(2 * keys.length);
        }
        ;

        // 查找键，找到则更新值，找不到则创建新的元素
        int i = rank(key);
        // i < N 保证了如果一个元素放在队尾，那么 i 与 N 一定相同，不会出现 key[i] 取 null 的时候
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    private void resize(int size) {
        Key[] tmpKeys = (Key[]) new Comparable[size];
        Value[] tmpValues = (Value[]) new Object[size];
        for (int i = 0; i < N; i++) {
            tmpKeys[i] = keys[i];
            tmpValues[i] = values[i];
        }

        keys = tmpKeys;
        values = tmpValues;
    }

    /**
     * 小于 key 的键的数量
     *
     * @param key
     * @return
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // 相较于 (lo + hi) / 2，防止了内存溢出
            int cmp = key.compareTo(keys[mid]);
            if (0 > cmp) {
                hi = mid - 1;
            } else if (0 < cmp) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    private boolean isEmpty() {
        return 0 == N;
    }

    /**
     * 最小的键
     *
     * @return
     */
    public Key min() {
        return keys[0];
    }

    /**
     * 最大的键
     *
     * @return
     */
    public Key max() {
        return keys[N - 1];
    }

    /**
     * 排名为 k 的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return keys[k];
    }

    /**
     * 大于等于 key 的最小键
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * 小于等于 key 的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (keys[i].equals(key)) {
            return keys[i];
        }

        return i < 1 ? null : keys[i - 1];
    }

    public Key delete(Key key) {
        int i = rank(key);
        if (!keys[i].equals(key) || size() == i) {
            return null;
        }

        Key item = keys[i];
        boolean lastOne = size() - 1 == i;
        if (!lastOne) {
            for (int j = i; j < size() - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }

            keys[N - 1] = null;
            values[N - 1] = null;
        } else {
            keys[i] = null;
            values[i] = null;
        }

        N--;
        if (N > 0 && N == keys.length / 4) {
            resize(keys.length / 2);
        }

        return item;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo), length = rank(hi); i < length; i++) {
            q.enqueue(keys[i]);
        }

        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }

        return q;
    }

    private boolean contains(Key key) {
        return null != get(key);
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(6);
        st.put(1, "1");
        st.put(2, "2");
        st.put(4, "4");
        st.put(5, "5");
        st.put(6, "6");
        Integer ceiling = st.ceiling(3);
        Integer floor = st.floor(0);
        System.out.println(ceiling);
        System.out.println(floor);
        st.delete(1);
    }
}
