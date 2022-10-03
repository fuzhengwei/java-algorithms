package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小傅哥，微信：fustack
 * @description 广度优先遍历
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class GraphBFS {

    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();
    private Graph G;

    public GraphBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);

            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

}
