package com.chapter1;

/**
 * 递归描述
 *
 * @author wangsen@qgutech.com
 * @since 2019/1/31 13:31
 */
public class RecursionDesc {

    public static void main(String[] args) {
//        printOut(98);
    }

    public static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }

        System.out.println("Num : " + n % 10);
    }

}
