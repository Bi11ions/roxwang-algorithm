package com.chapter2;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 14:50
 */
public class MaxSubSum {

    /**
     * O(n^3)
     *
     * @param arr 目标数组
     * @return 最大子序列的和
     */
    public static int firstMethod(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int thisSum = 0;
                for (int k = 0; k <= j; k++) {
                    thisSum += arr[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * O(n^2)
     *
     * @param arr 目标数组
     * @return 最大子序列的和
     */
    public static int secondMethod(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int thisSum = 0;
            for (int j = i; j < arr.length; j++) {
                thisSum += arr[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * O(N*logN)
     *
     * @param arr   目标数组
     * @param left  数组左边界
     * @param right 数组右边界
     * @return 最大子序列的和
     */
    public static int thirdMethod(int[] arr, int left, int right) {
        if (left == right) {
            if (left == right) {
                return arr[left] > 0 ? arr[left] : 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = thirdMethod(arr, left, center);
        int maxRightSum = thirdMethod(arr, center + 1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return (maxLeftBorderSum + maxRightBorderSum) >= maxLeftSum ?
                (maxLeftBorderSum + maxRightBorderSum) :
                maxLeftSum >= maxRightSum ?
                        maxLeftSum :
                        maxRightSum;
    }

    public static int fourthMethod(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;

        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSum;
    }
}
