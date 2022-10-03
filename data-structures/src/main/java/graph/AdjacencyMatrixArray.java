package graph;

/**
 * @author 小傅哥，微信：fustack
 * @description 邻接矩阵 Adjacency Matrix 使用两个数组实现
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class AdjacencyMatrixArray {

    // 图的顶点数
    protected int v;
    // 图的边个数
    protected int e;
    // 图的矩阵
    protected int[][] table;

    public AdjacencyMatrixArray(int v, int e) {
        this.v = v;
        this.e = e;
        table = new int[v][v];
    }

    // 无方向&无权重
    public static class U_U extends AdjacencyMatrixArray {

        public U_U(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y) {
            table[x][y] = 1;
            table[y][x] = 1;
        }

    }

    // 无方向&有权重
    public static class U_W extends AdjacencyMatrixArray {

        public U_W(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y, int weight) {
            table[x][y] = weight;
            table[y][x] = weight;
        }

    }

    // 有方向&无权重
    public static class D_U extends AdjacencyMatrixArray {

        public D_U(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y) {
            table[x][y] = 1;
        }

    }

    // 有方向&有权重
    public static class D_W extends AdjacencyMatrixArray {

        public D_W(int v, int e) {
            super(v, e);
        }

        public void insert(int x, int y, int weight) {
            table[x][y] = weight;
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("图配置：V = %d, E = %d\n", v, e));
        builder.append("---------------------------\n");
        builder.append("  | ");
        for (int i = 0; i < v; i++) {
            builder.append(String.format("%d | ", i));
        }
        builder.append("\n⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛⏛\n");
        for (int i = 0; i < v; i++) {
            builder.append(i);
            builder.append(" | ");
            for (int j = 0; j < v; j++) {
                builder.append(String.format("%d | ", table[i][j]));
            }
            builder.append("\n");
            builder.append("---------------------------");
            builder.append("\n");
        }
        return builder.toString();
    }

}

