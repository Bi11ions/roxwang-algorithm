package com.chengfayun;

import java.util.Scanner;

/**
 * 输入最多的直接/间接依赖的数
 *
 * input
 * 4
 * A B
 * A D
 * B C
 * C D
 *
 * output D
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if (1 > length) {
            return;
        }


        for (int i = 0; i < length; i++) {

        }
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

}