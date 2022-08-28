package cn.bugstack.algorithms.data.hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * 分离链/拉链法（Separate chaining）在单独的链接中，该过程涉及为每个搜索数组索引构建一个带有键值对的链表。碰撞的项目通过单个链表链接在一起，可以遍历该链表以使用唯一的搜索键访问项目。
 */
public class HashMap02BySeparateChaining<K, V> implements Map<K, V> {

    private final Logger logger = LoggerFactory.getLogger(HashMap02BySeparateChaining.class);

    private final LinkedList<Node<K, V>>[] tab = new LinkedList[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new LinkedList<>();
            tab[idx].add(new Node<>(key, value));
        } else {
            tab[idx].add(new Node<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        for (Node<K, V> kvNode : tab[idx]) {
            if (key.equals(kvNode.getKey())) {
                return kvNode.value;
            }
        }
        return null;
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }

}
