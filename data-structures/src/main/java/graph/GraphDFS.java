package graph;

import java.util.ArrayList;

/**
 * @author 小傅哥，微信：fustack
 * @description 深度优先遍历
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class GraphDFS {

    private Graph graph;
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();
    private boolean[] visited;

    public GraphDFS(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        // 深度优先，前序遍历
        pre.add(v);
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        // 深度优先，后序遍历
        post.add(v);
    }


    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

}
