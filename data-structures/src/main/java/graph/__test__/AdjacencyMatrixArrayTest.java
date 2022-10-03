package graph.__test__;

import graph.AdjacencyMatrixArray;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 邻接矩阵 Adjacency Matrix 使用两个数组实现
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class AdjacencyMatrixArrayTest {

    @Test
    public void test_U_U() {
        AdjacencyMatrixArray.U_U matrix = new AdjacencyMatrixArray.U_U(6, 9);
        matrix.insert(0, 1);
        matrix.insert(0, 3);
        matrix.insert(0, 2);
        matrix.insert(0, 4);
        matrix.insert(1, 4);
        matrix.insert(2, 4);
        matrix.insert(2, 5);
        matrix.insert(3, 5);
        System.out.println(matrix);
    }

    @Test
    public void test_D_U() {
        AdjacencyMatrixArray.D_U matrix = new AdjacencyMatrixArray.D_U(6, 9);
        matrix.insert(0, 1);
        matrix.insert(0, 3);
        matrix.insert(0, 2);
        matrix.insert(0, 4);
        matrix.insert(1, 4);
        matrix.insert(2, 4);
        matrix.insert(2, 5);
        matrix.insert(3, 5);
        System.out.println(matrix);
    }

    @Test
    public void test_U_W() {
        AdjacencyMatrixArray.U_W matrix = new AdjacencyMatrixArray.U_W(6, 9);
        matrix.insert(0, 1, 1);
        matrix.insert(0, 3, 2);
        matrix.insert(0, 2, 3);
        matrix.insert(0, 4, 5);
        matrix.insert(1, 4, 1);
        matrix.insert(2, 4, 3);
        matrix.insert(2, 5, 7);
        matrix.insert(3, 5, 4);
        System.out.println(matrix);
    }

    @Test
    public void test_D_W() {
        AdjacencyMatrixArray.D_W matrix = new AdjacencyMatrixArray.D_W(6, 9);
        matrix.insert(0, 1, 1);
        matrix.insert(0, 3, 2);
        matrix.insert(0, 2, 3);
        matrix.insert(0, 4, 5);
        matrix.insert(1, 4, 1);
        matrix.insert(2, 4, 3);
        matrix.insert(2, 5, 7);
        matrix.insert(3, 5, 4);
        System.out.println(matrix);
    }

}
