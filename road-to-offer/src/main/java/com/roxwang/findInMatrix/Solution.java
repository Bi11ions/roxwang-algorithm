package com.roxwang.findInMatrix;

import org.junit.Test;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 解题思路：
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
 * 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/22 16:01
 */
public class Solution {
    @Test
    public void test() {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean inMatrix = findInMatrix(24, matrix);
        System.out.println(inMatrix);
    }

    private boolean findInMatrix(int target, int[][] matrix) {
        if (null == matrix || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int length = matrix.length;
        int row = 0;
        int column = length - 1;
        while (row < length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }

            if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }
}
