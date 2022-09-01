package heap.__test__;

import heap.MaxHeap;
import heap.MinHeap;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeapTest {

    private final Logger logger = LoggerFactory.getLogger(HeapTest.class);

    @Test
    public void test_min_heap() {
        MinHeap heap = new MinHeap();

        // 存入元素
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(11);
        heap.add(4);
        heap.add(6);
        heap.add(7);
        heap.add(12);
        heap.add(15);
        heap.add(10);
        heap.add(9);
        heap.add(8);

        // 弹出元素
        while (heap.peek() != null){
            logger.info("测试结果：{}", heap.poll());
        }

    }

    @Test
    public void test_max_heap() {
        MaxHeap heap = new MaxHeap();
        // 存入元素
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(11);
        heap.add(4);
        heap.add(6);
        heap.add(7);
        heap.add(12);
        heap.add(15);
        heap.add(10);
        heap.add(9);
        heap.add(8);

        // 弹出元素
        while (heap.peek() != null){
            logger.info("测试结果：{}", heap.poll());
        }

    }

}
