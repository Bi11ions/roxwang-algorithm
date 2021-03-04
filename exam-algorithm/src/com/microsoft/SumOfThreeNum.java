package com.microsoft;

/**
 * 输入 n，求所有符合 x^2+y^2+z^2 = n 的 x, y, z 的方案数。（x, y, z为非负整数）
 * <p>
 * n <= 1000000
 * x, y, z满足 (x<=y<=z)，只要选择出来的三个数相同就算同一种方案
 * <p>
 * 样例
 * 样例 1：
 * 输入：n = 3
 * 输出：1
 * 解释：都为 1，一共有 1 种方案。
 * 样例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：当 x = 0, y = 0, z = 0 时等式成立。
 */
public class SumOfThreeNum {

    public int threeSum(int n) {
        int m = (int) Math.round(Math.sqrt(n));
        if (m * m > n) {
            m--;
        }

        int result = 0;
        for (int i = 0; i <= m; i++) {
            int res = n - i * i;
            int left = i;
            int right = m;
            while (left <= right) {
                int tmp = left * left + right * right;
                if (tmp > res) {
                    right--;
                } else if (tmp < res) {
                    left++;
                } else {
                    result++;
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfThreeNum sumOfThreeNum = new SumOfThreeNum();
        System.out.println(sumOfThreeNum.threeSum(0));
    }

}
