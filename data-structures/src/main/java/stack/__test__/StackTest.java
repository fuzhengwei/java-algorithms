package stack.__test__;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stack.ArrayDeque;
import stack.Deque;

public class StackTest {

    private final Logger logger = LoggerFactory.getLogger(StackTest.class);

    @Test
    public void test_stack() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        deque.push(6);
        deque.push(7);
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
        logger.info("弹出元素：{}", deque.pop());
    }

}
