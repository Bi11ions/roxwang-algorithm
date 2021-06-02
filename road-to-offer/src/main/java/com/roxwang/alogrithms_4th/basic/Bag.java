package com.roxwang.alogrithms_4th.basic;

import java.util.Iterator;

/**
 * @author Bi11ions
 * @description 包
 * @date 2021/4/26 15:12
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first; // 链表的首结点

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) { // 和 Stack 的 push() 方法完全相同
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
