package disjoint_set.__test__;

import disjoint_set.*;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 并查集测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DisjointSetTest {

    @Test
    public void test_01() {
        IDisjointSet disjointSet = new DisjointSet01(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素\n");
        disjointSet.union(0, 1);
        disjointSet.union(0, 2);
        disjointSet.union(0, 3);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);

        disjointSet.union(1, 8);
        System.out.println(disjointSet);
    }

    @Test
    public void test_02() {
        IDisjointSet disjointSet = new DisjointSet02(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素：\n");
        disjointSet.union(0, 1);
        disjointSet.union(0, 2);
        disjointSet.union(0, 3);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);

        disjointSet.union(1, 8);
        System.out.println(disjointSet);
    }

    @Test
    public void test_03() {
        IDisjointSet disjointSet = new DisjointSet03(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素：\n");
        disjointSet.union(0, 1);
        disjointSet.union(0, 2);
        disjointSet.union(0, 3);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);

        disjointSet.union(1, 8);
        System.out.println(disjointSet);
    }

    @Test
    public void test_04() {
        IDisjointSet disjointSet = new DisjointSet04(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素：\n");
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(2, 1);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);

        disjointSet.union(8, 1);
        System.out.println(disjointSet);
    }

    @Test
    public void test_05() {
        IDisjointSet disjointSet = new DisjointSet05(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素：\n");
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(2, 1);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);
        disjointSet.union(8, 1);
        System.out.println(disjointSet);
    }

    @Test
    public void test_06() {
        IDisjointSet disjointSet = new DisjointSet06(9);
        System.out.println(disjointSet);

        System.out.println("\n合并元素：\n");
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(2, 1);
        disjointSet.union(6, 4);
        disjointSet.union(6, 5);
        disjointSet.union(6, 7);
        disjointSet.union(6, 8);
        System.out.println(disjointSet);
        disjointSet.union(8, 1);
        System.out.println(disjointSet);

    }

}
