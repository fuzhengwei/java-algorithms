package cn.bugstack.algorithms.data.array;

/**
 * @author 小傅哥，微信：fustack
 * @description List 接口
 * @github https://github.com/fuzhengwei/java-algorithms
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface List<E> {

    boolean add(E e);

    E remove(int index);

    E get(int index);

}
