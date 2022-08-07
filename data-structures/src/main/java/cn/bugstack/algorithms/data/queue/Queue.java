package cn.bugstack.algorithms.data.queue;

/**
 * @author 小傅哥，微信：fustack
 * @description 单端队列接口
 * Java泛型中的标记符含义：
 * E - Element （元素,在集合中使用）
 * T - Type （Java类）
 * K - Key （键）
 * V - Value （值）
 * N - Number（数值类型）
 * ? - 表示不确定的Java类型
 * @github https://github.com/fuzhengwei/java-algorithms
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface Queue<E> {

    boolean add(E e);

    boolean offer(E e);

    E poll();

    E peek();

}
