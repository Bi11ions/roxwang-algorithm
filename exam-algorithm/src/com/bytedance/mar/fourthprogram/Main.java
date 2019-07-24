package com.bytedance.mar.fourthprogram;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangsen@qgutech.com
 * @since 2019/3/16 11:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() < 1 || s.length() > 2) {
            System.out.println(0);
            return;
        }

        String[] split = s.split("\\s+");
        int[] arr = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        int n = arr[1];
        int m = arr[2];
        if (n < 1 || m < 1) {
            System.out.println(0);
            return;
        }

        String s1 = sc.nextLine();
        if (s1.length() != n) {
            System.out.println(0);
            return;
        }

        String[] splitArr = s1.split("\\s+");
        double[] existNumArr = Arrays.stream(splitArr).mapToDouble(Double::valueOf).toArray();
        BigDecimal result = getMaxLengthInArr(n, m, existNumArr);
        System.out.println(result);
    }

    private static BigDecimal getMaxLengthInArr(int n, int m, double[] existNumArr) {
        double[] sortedArr = Arrays.stream(existNumArr).sorted().toArray();
        if (m < n) {
            return new BigDecimal(sortedArr[m]).setScale(2, BigDecimal.ROUND_HALF_UP);
        }


        return BigDecimal.ZERO;
    }
}
