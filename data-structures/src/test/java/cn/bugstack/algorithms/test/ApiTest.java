package cn.bugstack.algorithms.test;

import array_list.ArrayList;
import array_list.List;
import linked_list.LinkedList;
import org.junit.jupiter.api.Test;
import queue.DelayQueue;
import queue.Delayed;
import queue.Queue;
import stack.ArrayDeque;
import stack.Deque;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.TimeUnit;


public class ApiTest {

    @Test
    public void test_linked_list() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("x");
    }

    @Test
    public void test_stack() {
        Stack<String> stack = new Stack<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Deque<String> deque = new ArrayDeque<>();
        deque.push("1");
        deque.push("2");
        deque.push("3");

        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());

        Deque<Integer> stackArray = new ArrayDeque<>();
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);

        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());


    }

    @Test
    public void test_array_list() {
        List<String> list = new ArrayList<>();
        list.add("");

        list.get(1);
    }

    @Test
    public void test_array() {
        String[][] x = new String[2][2];
        x[0][0] = "kdkkdll";
        x[0][1] = "dd";
        x[1][0] = "pppp";
        x[1][1] = "你好";

        System.out.println(Integer.toHexString(x[0][0].hashCode()));
        System.out.println(Integer.toHexString(x[0][1].hashCode()));
        System.out.println(Integer.toHexString(x[1][0].hashCode()));
        System.out.println(Integer.toHexString(x[1][1].hashCode()));
    }

    @Test
    public void test_system_arraycopy() {
        int[] i = new int[3];
        i[0] = 0;
        i[1] = 1;
        i[2] = 2;

        int[] j = new int[3];

        System.arraycopy(i, 0, j, 0, 3);

        System.out.println(Arrays.toString(j));
    }


    @Test
    public void test_queue() throws InterruptedException {
        Queue<Job> queue = new DelayQueue<>();
        queue.add(new Job("1号", 1000L));
        queue.add(new Job("3号", 3000L));
        queue.add(new Job("4号", 4000L));
        queue.add(new Job("5号", 5000L));
        queue.add(new Job("2号", 2000L));

        while (true) {
            Job poll = queue.poll();
            if (null == poll) {
                TimeUnit.MILLISECONDS.sleep(10);
                continue;
            }
            System.out.println(poll.getName());
        }
    }

    static class Job implements Delayed, Serializable {


        private final String name;
        private final Long begin;
        private final Long delayTime;

        public Job(String name, Long delayTime) {
            this.name = name;
            this.begin = System.currentTimeMillis();
            this.delayTime = delayTime;//延时时长
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(begin + delayTime - System.currentTimeMillis(), TimeUnit.MICROSECONDS);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Delayed o) {
            Job job = (Job) o;
            return (int) (this.getDelay(TimeUnit.MICROSECONDS) - job.getDelay(TimeUnit.MICROSECONDS));
        }
    }

    @Test
    public void test_Deque() {
        Deque<String> deque = new ArrayDeque<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");
        deque.push("i");

        System.out.println("数据出栈：");
        while (!deque.isEmpty()) {
            System.out.print(deque.pop() + " ");
        }
    }

}