package cn.bugstack.algorithms.data.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayDeque<E> implements Deque<E> {

    private final Logger logger = LoggerFactory.getLogger(ArrayDeque.class);

    /**
     * 存储双端队列元素的数组。双端队列的容量就是这个数组的长度，它总是 2 的幂。
     * 数组永远不允许变满，除非在 addX 方法中短暂地在变满后立即调整大小（请参阅 doubleCapacity），
     * 从而避免头部和尾部环绕以彼此相等。我们还保证所有不包含双端队列元素的数组单元始终为空。
     */
    transient Object[] elements;

    /**
     * 双端队列头部元素的索引（将被 remove() 或 pop() 删除的元素）；如果双端队列为空，则为等于 tail 的任意数字。
     */
    transient int head;

    /**
     * 将下一个元素添加到双端队列尾部的索引（通过 addLast(E)、add(E) 或 push(E)）
     */
    transient int tail;

    /**
     * 构造一个空数组双端队列，其初始容量足以容量16个元素
     */
    public ArrayDeque() {
        // 默认是16个长度，这里小傅哥把它缩小些，方便测试
        elements = new Object[2];
    }

    /**
     * 双端队列的容量翻倍。仅在满时调用，即当头部和尾部缠绕成相等时。
     */
    private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];

        /*
         * src      - 源数组
         * srcPos   – 源数组中的起始位置
         * dest     - 目标数组
         * destPos  – 目标数据中的起始位置
         * length   – 要复制的数组元素的数量
         */

        // 第一次拷贝元素：[2、1、4、3] 将数组中的扩容后一半元素拷贝到新数组0开始往后的位置。拷贝4、3
        System.arraycopy(elements, p, a, 0, r);
        // 第二次拷贝元素：[2、1、4、3] 将数组中的前面一半数量的元素，拷贝到新数组后一半开始的位置往后。拷贝2、1
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }

    @Override
    public void push(E e) {
        if (e == null)
            throw new NullPointerException();
        elements[head = (head - 1) & (elements.length - 1)] = e;
        logger.info("push.idx head：{}", head);
        if (head == tail)
            doubleCapacity();
    }

    @Override
    public E pop() {
        int h = head;
        @SuppressWarnings("unchecked")
        E result = (E) elements[h];
        if (result == null) {
            return null;
        }
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        logger.info("pop.idx {} = {} & {}", head, Integer.toBinaryString(h + 1), Integer.toBinaryString(elements.length - 1));
        return result;
    }

}
