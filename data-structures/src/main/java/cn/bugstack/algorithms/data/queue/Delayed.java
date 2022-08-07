package cn.bugstack.algorithms.data.queue;

import java.util.concurrent.TimeUnit;

/**
 * @author 小傅哥，微信：fustack
 * @description 延迟队列接口
 * @github https://github.com/fuzhengwei/java-algorithms
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface Delayed extends Comparable<Delayed>{

    long getDelay(TimeUnit unit);

}
