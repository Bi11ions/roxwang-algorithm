package com.bytedance.mar.firstprogram;

import java.util.Scanner;

/**
 * @author wangsen@qgutech.com
 * @since 2019/3/16 9:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goodsPrice = sc.nextInt();
        if (0 == goodsPrice) {
            System.out.println(0);
            return;
        }

        int coins[] = {1, 4, 16, 64};
        int totalMoney = 1024;
        int k = totalMoney - goodsPrice;

        int road[] = new int[k + 1];
        int min = getMinCount(k, coins, road);
        if (min > Integer.MAX_VALUE - k) {
            System.out.println("零钱不够！");
        } else {
            System.out.println(min);
        }
    }

    private static int getMinCount(int k, int c[], int r[]) {
        int a[] = new int[k + 1];
        a[0] = 0;
        for (int x = 1; x < k + 1; x++) {
            if (x >= c[0]) {
                a[x] = a[x - c[0]] + 1;
                r[x] = c[0];
            } else {
                a[x] = Integer.MAX_VALUE - k;
            }
            for (int i = 1; i < c.length; i++) {
                if (x >= c[i] && (a[x] > a[x - c[i]] + 1)) {
                    a[x] = a[x - c[i]] + 1;
                    r[x] = c[i];
                }
            }
        }
        return a[k];
    }
}
