package graph;

import java.util.TreeSet;

/**
 * @author 小傅哥，微信：fustack
 * @description 图，最终都是红黑树的实现方式
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Graph {

    // 图的顶点数
    private int v;
    // 图的边个数
    private int e;
    // 图的矩阵
    private TreeSet<Integer>[] table;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        table = new TreeSet[v];
        for (int i = 0; i < v; i++) {
            table[i] = new TreeSet<>();
        }
    }

    public void insert(int x, int y) {
        table[x].add(y);
        table[y].add(x);
    }

    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return table[v].contains(w);
    }

    public TreeSet<Integer> adj(int v) {
        validateVertex(v);
        return table[v];
    }

    public int degree(int v) {
        return adj(v).size();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.v)
            throw new IllegalArgumentException("vertex " + v + " is invalid.");
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("图配置：V = %d, E = %d\n", v, e));
        builder.append("⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛\n");
        for (int i = 0; i < v; i++) {
            builder.append(String.format("%d | ", i));
            for (int w : table[i]) {
                builder.append(String.format("%d | ", w));
            }
            builder.append("\n");
            builder.append("-------------------------------");
            builder.append("\n");
        }
        return builder.toString();
    }

}
