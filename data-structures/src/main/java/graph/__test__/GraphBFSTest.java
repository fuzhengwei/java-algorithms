package graph.__test__;

import graph.Graph;
import graph.GraphBFS;
import graph.GraphDFS;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 广度优先遍历
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class GraphBFSTest {

    @Test
    public void test_GraphBFS() {
        Graph graph = new Graph(7, 6);
        graph.insert(0, 1);
        graph.insert(0, 3);
        graph.insert(1, 2);
        graph.insert(1, 5);
        graph.insert(2, 4);
        graph.insert(2, 6);
        GraphBFS dfs = new GraphBFS(graph);
        System.out.println(graph);

        System.out.println(dfs.order());
    }


}
