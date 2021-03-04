package com.leetcode.all.eightQueen.getOneSolution;

public class Solution {
    /**
     * 总共解法
     */
    private static int total = 0;

    public static void findQueen(int[][] array, int index) {
        if (index > array.length - 1) {
            total++;
            printQueen(array);
            return;
        }

        for (int m = 0, len = array.length; m < len; m++) {
            if (check(array, index, m)) {
                array[index][m] = 1;
                findQueen(array, index + 1);
                array[index][m] = 0;
            }

        }
    }

    /**
     * 判断节点是否符合规则
     *
     * @param index
     * @param m
     * @return
     */
    private static boolean check(int[][] array, int index, int m) {
        // 检查行列是否冲突
        for (int i = 0, len = array.length; i < len; i++) {
            if (1 == array[i][m]) {
                return false;
            }
        }

        // 检查左对角线
        for (int i = index - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
            if (1 == array[i][j]) {
                return false;
            }
        }

        // 检查右对角线
        for (int i = index - 1, j = m + 1, len = array.length; i >= 0 && j < len; i--, j++) {
            if (1 == array[i][j]) {
                return false;
            }
        }

        return true;
    }

    private static void printQueen(int[][] array) {
        System.out.println("方案 - " + total + ": ");
        for (int i = 0, len = array.length; i < len; i++) {
            for (int j = 0, col = array[i].length; j < col; j++) {
                if (array[i][j] == 1) {
                    System.out.print("O ");
                } else {
                    System.out.print("+ ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution.findQueen(new int[8][8], 0);
        System.out.println("解决方案共有：" + total);
    }
}
