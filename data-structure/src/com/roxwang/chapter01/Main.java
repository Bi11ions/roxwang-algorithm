package com.roxwang.chapter01;

/**
 * @author wangsen@qgutech.com
 * @since 2019/2/25 17:24
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.add(1, 100);
        System.out.println(array);
    }
}