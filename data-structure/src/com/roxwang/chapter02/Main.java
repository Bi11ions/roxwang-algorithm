package com.roxwang.chapter02;

/**
 * @author wangsen@qgutech.com
 * @since 2019/2/25 17:24
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        System.out.println("Push : ");
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        System.out.println("Pop : ");
        while (stack.getSize() > 0) {
            stack.pop();
            System.out.println(stack);
        }
    }
}
