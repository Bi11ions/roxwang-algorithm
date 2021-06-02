package com.roxwang.alogrithms_4th.graph;

import com.roxwang.alogrithms_4th.basic.Graph;
import com.roxwang.alogrithms_4th.basic.Stack;

/**
 * @author Bi11ions
 * @description TODO
 * @date 2021/4/27 16:30
 */
public class DepthFirstPaths {
    private boolean[] marked; // 标记这个顶点是否调用过 dfs
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点


    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    private boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(s);
        return path;
    }
}
