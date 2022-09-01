package queue;

/**
 * @author 小傅哥，微信：fustack
 * @description 阻塞队列接口
 * @github https://github.com/fuzhengwei/java-algorithms
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface BlockingQueue<E> extends Queue<E>{

    boolean add(E e);

    boolean offer(E e);

}
