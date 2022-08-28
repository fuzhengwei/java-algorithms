package cn.bugstack.algorithms.test;

import cn.bugstack.algorithms.data.array.ArrayList;
import cn.bugstack.algorithms.data.hash.*;
import cn.bugstack.algorithms.data.linked.LinkedList;
import cn.bugstack.algorithms.data.linked.List;
import cn.bugstack.algorithms.data.queue.DelayQueue;
import cn.bugstack.algorithms.data.queue.Delayed;
import cn.bugstack.algorithms.data.queue.Queue;
import cn.bugstack.algorithms.data.stack.ArrayDeque;
import cn.bugstack.algorithms.data.stack.Deque;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author 小傅哥，微信：fustack
 * @description 算法测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class AlgorithmsTest {

    private Logger logger = LoggerFactory.getLogger(AlgorithmsTest.class);

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

    @Test
    public void test_arraycopy() {
        Object[] elements = new Object[8];
        elements[7] = 7;
        elements[6] = 6;
        elements[5] = 5;
        elements[4] = 4;
        elements[3] = 3;
        elements[2] = 2;
        elements[1] = 1;
        elements[0] = 0;

        Object[] a = new Object[16];

    }

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

    @Test
    public void test_hashMap01() {
        Map<String, String> map = new HashMap01<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }

    @Test
    public void test_hashMap02() {
        Map<String, String> map = new HashMap02BySeparateChaining<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }

    @Test
    public void test_hashMap03() {
        Map<String, String> map = new HashMap03ByOpenAddressing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        logger.info("数据结构：{}", map);
    }

    @Test
    public void test_hashMap04() {
        Map<String, String> map = new HashMap04ByCoalescedHashing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("12"));

        logger.info("数据结构：{}", map);
    }

    @Test
    public void test_hashMap05() {
        java.util.Map<String, String> map = new HashMap05ByCuckooHashing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("12"));
        logger.info("数据结构：{}", map);
    }

    @Test
    public void test_hashMap06() {
        HashMap06ByHopscotchHashing<Integer> map = new HashMap06ByHopscotchHashing<>();
        map.insert(1);
        map.insert(5);
        map.insert(9);
        map.insert(12);

        logger.info("数据结构：{}", map);
    }

    @Test
    public void test_hashMap07() {
        Map<String, String> map = new HashMap07ByRobinHoodHashing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("12"));

        logger.info("数据结构：{}", map);
    }

}