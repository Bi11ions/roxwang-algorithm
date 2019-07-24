package com.roxwang;

import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangsen@qgutech.com
 * @since 2019/7/9 17:20
 */
public class BitMapSort {
    public static int[] bitMapSort(int[] arr) {
        // 先找出最大值、最小值
        int max = arr[0];
        int min = max;

        for (int i : arr) {
            if (max < i) {
                max = i;
            }

            if (min > i) {
                min = i;
            }
        }

        // 初始化位图大小
        // 解决数组有负数的问题
        int temp = 0;
        int[] newArr = null;
        if (min < 0) {
            temp = 0 - min;
            newArr = new int[max - min + 1];
        } else {
            newArr = new int[max + 1];
            min = 0;
        }

        // 构建位图
        for (int i : arr) {
            // 位图算法
            newArr[i + temp]++;
        }

        // 重新调整 arr 数组中的元素
        int index = 0;
        for (int i = 0; i < newArr.length; i++) {
            // 位图为1就输出，对数组进行排序
            while (newArr[i] > 0) {
                arr[index] = i + min;
                index++;
                newArr[i]--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> System.out.println("我是延迟执行的线程...."), 20, TimeUnit.SECONDS);
        executor.shutdown();
//        int[] arr = {5, 2, 3, 7, 1};
        int[] arr = {5, 2, -3, 7, 1};
        int[] sortedArr = bitMapSort(arr);
        Arrays.stream(sortedArr).forEach(System.out::println);
//            if (null != executor && !executor.isShutdown()) {
//                executor.shutdown();
//                boolean isDead = false;
//                while(!isDead) {
//                    try {
//                        isDead = executor.awaitTermination(1, TimeUnit.MINUTES);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

    }
}
