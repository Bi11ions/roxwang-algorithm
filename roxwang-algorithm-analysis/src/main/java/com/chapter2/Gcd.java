package com.chapter2;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 16:49
 */
public class Gcd {
    private static long gcd(long m, long n) {
        while(n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }

        return m;
    }

    public static void main(String[] args) {
        long gcd = gcd(343, 177);
        System.out.println(gcd);
    }
}