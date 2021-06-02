package com.roxwang.alogrithms_4th.graph;

import com.roxwang.alogrithms_4th.basic.Graph;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/4/26 15:47
 */
public class GraphUtils {
    /**
     * 计算 v 的度数
     *
     * @param G 图
     * @param V 计算的目标节点
     * @return
     */
    public static int degree(Graph G, int V) {
        int degree = 0;
        for (Integer w : G.adj(V)) {
            degree++;
        }

        return degree;
    }

    /**
     * 计算图的最大度数的顶点
     *
     * @param G 图
     * @return 度数
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                max = degree(G, v);
        return max;
    }

    /**
     * 计算图的平均度数
     *
     * @param G 图
     * @return 平均度数
     */
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * 计算环的个数
     *
     * @param G 图
     * @return 环个数
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count / 2; // 每条边都被记过两次
    }
}
