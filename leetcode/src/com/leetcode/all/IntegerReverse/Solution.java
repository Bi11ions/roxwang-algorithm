package com.leetcode.all.IntegerReverse;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 *
 */
public class Solution {
    public static int reverse(int x) {
        boolean lowThanZero = x < 0;
        String numberString = (x + "").replaceAll("-", "");
        StringBuilder sb = new StringBuilder(numberString);
        int reversedNumber = 0;
        try {
            reversedNumber = Integer.parseInt(sb.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return lowThanZero ? -reversedNumber : reversedNumber;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    /**
     * 官方解法：
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * int pop = x % 10;
     * x /= 10;
     * temp = rev * 10 + pop;
     * rev = temp;
     *
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到  rev 的后面。最后，rev 将与 xx 相反
     *
     * 但是 temp = rev * 10 + pop 可能会导致内存溢出
     * 幸运的是，事先检查这个语句是否会导致溢出很容易。
     * 为了便于解释，我们假设 rev 是正数。
     * 1. temp  = rev * 10 + temp 溢出，那么就有 rev >= Integer.MAX_VALUE / 10
     * 2. 所以 rev > Integer.MAX_VALUE / 10 时，一定溢出
     * 3. 如果 rev == Integer.MAX_VALUE / 10 时，只需要 pop > 7, temp = rev * 10 + pop 溢出
     */
    public static int officialSolution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }
}
