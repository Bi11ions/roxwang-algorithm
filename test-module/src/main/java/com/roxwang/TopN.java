package com.roxwang;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 在无序数中，去前 N 个数据。 本例中使用小顶堆的方式
 *
 * @author wangsen@qgutech.com
 * @since 2019/7/5 11:22
 */
public class TopN {
    /**
     * 父节点
     *
     * @param n
     * @return
     */
    private int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * 左孩子
     *
     * @param n
     * @return
     */
    private int left(int n) {
        return 2 * n + 1;
    }

    /**
     * 右孩子
     *
     * @return
     */
    private int right(int n) {
        return 2 * n + 2;
    }

    /**
     * 初始化构建堆
     *
     * @param n
     * @param data
     */
    private void buildHeap(int n, int[] data) {
        for (int i = 0; i < n; i++) {
            int t = i;
            // 调整堆. 如果当前节点比父节点值小，那么与父节点的值相互交换，并将t置为当前节点位置
            while (t != 0 && data[parent(t)] > data[t]) {
                swap(parent(t), t, data);
                t = parent(t);
            }
        }
    }

    /**
     * 调整 data[i]
     *
     * @param i
     * @param n
     * @param data
     */
    private void adjust(int i, int n, int[] data) {
        // 小于堆顶则不放入
        if (data[i] <= data[0]) {
            return;
        }

        // 置换堆顶
        swap(i, 0, data);
        // 调整堆顶
        int t = 0;
        while ((left(t) < n && data[t] > data[left(t)])
                || (right(t) < n && data[t] > data[right(t)])) {
            // 左孩子更小，与左孩子替换
            if (data[left(t)] < data[right(t)]) {
                swap(t, left(t), data);
                t = left(t);
            } else {
                swap(t, right(t), data);
                t = right(t);
            }
        }
    }

    /**
     * 交换
     *
     * @param sourceIndex
     * @param targetIndex
     * @param data        数组对象
     */
    private void swap(int sourceIndex, int targetIndex, int[] data) {
        int temp = data[sourceIndex];
        data[sourceIndex] = data[targetIndex];
        data[targetIndex] = temp;
    }

    /**
     * 寻找 TopN，该方法改变Data，将TopN 排到最前面
     *
     * @param n    小顶堆范围
     * @param data 数据数组
     */
    public void findTopN(int n, int[] data) {
        // 先构建 n 个数的小顶堆
        buildHeap(n, data);
        // n 往后的数据进行调整
        for (int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
    }

    public void printHeap(int n, int[] data) {
        if (n < 1 || null == data || data.length < 1) {
            return;
        }

        int sum = 0;
        int times = 0;
        while (true) {
            double pow = Math.pow(2, times++);
            sum += pow;
            if (n < sum) {
                break;
            }
        }

        int j = 0;
        int index = 0;
        while (j < times) {
            double pow = Math.pow(2, j++);
            for (int k = 0; k < pow && index < data.length; k++) {
                System.out.print(data[index++] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        IntStream intStream = random.ints(1, 100);
        List<Integer> initNumList = intStream.limit(10).boxed().collect(Collectors.toList());
        int[] initNumArr = new int[initNumList.size()];
        int i = 0;
        for (Integer integer : initNumList) {
            initNumArr[i++] = integer;
        }

        TopN topN = new TopN();
        topN.findTopN(10, initNumArr);
        topN.printHeap(10, initNumArr);
    }
}