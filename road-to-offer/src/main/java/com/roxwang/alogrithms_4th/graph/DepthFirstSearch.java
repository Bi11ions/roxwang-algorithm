package com.roxwang.alogrithms_4th.graph;

import com.roxwang.alogrithms_4th.basic.Graph;

/**
 * @author Bi11ions
 * @description 图的深度优先搜索
 * @date 2021/4/26 16:33
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
