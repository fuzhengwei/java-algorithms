package cn.bugstack.algorithms.test;


import cn.bugstack.algorithms.LinkedList;
import cn.bugstack.algorithms.List;

public class ApiTest {

    public static void main(String[] args) {
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

}
