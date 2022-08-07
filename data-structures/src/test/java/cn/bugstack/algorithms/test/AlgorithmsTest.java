package cn.bugstack.algorithms.test;

import cn.bugstack.algorithms.data.array.ArrayList;
import cn.bugstack.algorithms.data.linked.LinkedList;
import cn.bugstack.algorithms.data.linked.List;
import cn.bugstack.algorithms.data.queue.DelayQueue;
import cn.bugstack.algorithms.data.queue.Delayed;
import cn.bugstack.algorithms.data.queue.Queue;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author 小傅哥，微信：fustack
 * @description 算法测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class AlgorithmsTest {

    @Test
    public void test_linked_list() {
        List<String> list = new LinkedList<>();
        // 添加元素
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        // 打印列表
        list.printLinkList();
        // 头插元素
        list.addFirst("d");
        // 删除元素
        list.remove("b");
        // 打印列表
        list.printLinkList();
    }

    @Test
    public void test_array_list() {
        cn.bugstack.algorithms.data.array.List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");

        System.out.println(list);

        list.remove(9);

        System.out.println(list);
    }
    //        queue.add(new Job("1号",1000L));
//        queue.add(new Job("3号",3000L));
//        queue.add(new Job("4号",4000L));
//        queue.add(new Job("5号",5000L));
//        queue.add(new Job("2号",2000L));
    @Test
    public void test_queue() throws InterruptedException {
        Queue<Job> queue = new DelayQueue<>();

        queue.add(new Job("1号", 1000L));
        queue.add(new Job("3号", 3000L));
        queue.add(new Job("5号", 5000L));
        queue.add(new Job("11号", 11000L));
        queue.add(new Job("4号", 4000L));
        queue.add(new Job("6号", 6000L));
        queue.add(new Job("7号", 7000L));
        queue.add(new Job("12号", 12000L));
        queue.add(new Job("15号", 15000L));
        queue.add(new Job("10号", 10000L));
        queue.add(new Job("9号", 9000L));
        queue.add(new Job("8号", 8000L));

        while (true) {
            Job poll = queue.poll();
            if (null == poll) {
                Thread.sleep(10);
                continue;
            }
            System.out.println(poll.getName());
        }
    }

    class Job implements Delayed {

        private String name;
        private Long begin;
        private Long delayTime;

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

}
