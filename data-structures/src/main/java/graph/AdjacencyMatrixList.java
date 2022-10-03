package graph;

import java.util.LinkedList;

/**
 * @author 小傅哥，微信：fustack
 * @description 邻接表 Adjacency Matrix 使用数组 + 链表实现
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class AdjacencyMatrixList {

    // 图的顶点数
    protected int v;
    // 图的边个数
    protected int e;
    // 图的矩阵
    protected LinkedList<Integer[]>[] table;

    public AdjacencyMatrixList(int v, int e) {
        this.v = v;
        this.e = e;
        table = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // 无方向&无权重
    public static class U_U extends AdjacencyMatrixList {

        public U_U(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y) {
            table[x].add(new Integer[]{y});
            table[y].add(new Integer[]{x});
        }

    }

    // 无方向&有权重
    public static class U_W extends AdjacencyMatrixList {

        public U_W(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y, int weight) {
            table[x].add(new Integer[]{y, weight});
            table[y].add(new Integer[]{x, weight});
        }

    }

    // 有方向&无权重
    public static class D_U extends AdjacencyMatrixList {

        public D_U(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y) {
            table[x].add(new Integer[]{y});
        }

    }

    // 有方向&有权重
    public static class D_W extends AdjacencyMatrixList {

        public D_W(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y, int weight) {
            table[x].add(new Integer[]{y, weight});
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("图配置：V = %d, E = %d\n", v, e));
        builder.append("---------------------------\n");
        for (int i = 0; i < v; i++) {
            builder.append(i);
            builder.append(" |");
            for (Integer[] val : table[i]) {
                builder.append(" → ").append(val.length == 1 ? val[0] : "[" + val[0] + "," + val[1] + "]");
            }
            builder.append("\n");
            builder.append("---------------------------");
            builder.append("\n");
        }
        return builder.toString();
    }


}
