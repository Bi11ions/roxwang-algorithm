package com.roxwang.chapter02;

/**
 * @author wangsen@qgutech.com
 * @since 2019/2/27 17:28
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
