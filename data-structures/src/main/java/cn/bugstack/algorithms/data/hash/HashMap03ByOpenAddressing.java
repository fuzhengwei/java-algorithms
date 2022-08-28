package cn.bugstack.algorithms.data.hash;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 开放寻址（Open addressing）是另一种冲突解决技术，其中每个条目记录都存储在桶数组本身中，并通过探测执行哈希解决
 */
public class HashMap03ByOpenAddressing<K, V> implements Map<K, V> {

    private final Logger logger = LoggerFactory.getLogger(HashMap03ByOpenAddressing.class);

    private final Node<K, V>[] tab = new Node[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new Node<>(key, value);
        } else {
            for (int i = idx; i < tab.length; i++) {
                if (tab[i] == null) {
                    tab[i] = new Node<>(key, value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        for (int i = idx; i < tab.length; i ++){
            if (tab[idx] != null && tab[idx].key == key) {
                return tab[idx].value;
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

    @Override
    public String toString() {
        return "HashMap{" +
                "tab=" + JSON.toJSONString(tab) +
                '}';
    }

}
