package com.roxwang.alogrithms_4th.basic;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/6 15:27
 */
public class FixedCapacityStack<Item> {
    private Item[] a; // stack entries
    private int N; // size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}