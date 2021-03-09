package com.roxwang.alogrithms_4th.basic;

import java.util.Iterator;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/3/6 15:32
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first; // 指向最早添加的结点的链接
    private Node last; // 指向最近添加的结点的链接
    private int N; // 队列中的元素数量

    private class Node { // 定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    } // 或： N == 0.

    public int size() {
        return N;
    }

    public void enqueue(Item item) { // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() { // 从表头删除元素
        if (isEmpty()) {
            last = null;
            return null;
        }

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Queue.Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}