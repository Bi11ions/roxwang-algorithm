package com.roxwang.alogrithms_4th.basic;

import java.util.Iterator;
import java.util.Objects;

/**
 * 动态扩容 下压（LIFO）栈
 *
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/6 15:14
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Objects[1]; // 栈元素
    private int N = 0;

    public boolean isEmpty() {
        return 0 == N;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Objects[max];
        if (max >= 0) {
            System.arraycopy(a, 0, tmp, 0, N);
        }

        a = tmp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }

        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> { // 支持后进先出的迭代
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }
}
