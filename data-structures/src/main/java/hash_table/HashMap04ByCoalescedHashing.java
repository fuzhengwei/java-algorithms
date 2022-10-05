package hash_table;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * 合并散列（Coalesced hashing）是单独链接和开放寻址的混合，其中桶或节点在表中链接。该算法非常适合固定内存分配。通过识别哈希表上索引最大的空槽来解决合并哈希中的冲突，然后将冲突值插入该槽中。桶还链接到插入节点的插槽，其中包含其冲突哈希地址。
 */
public class HashMap04ByCoalescedHashing<K, V> implements Map<K, V> {

    private final Logger logger = LoggerFactory.getLogger(HashMap04ByCoalescedHashing.class);

    private final Node<K, V>[] tab = new Node[8];

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new Node<>(key, value);
            return;
        }

        if (Objects.equals(tab[idx].key, key)) {
            tab[idx] = new Node<>(key, value);
            return;
        }

        int cursor = tab.length - 1;
        while (tab[cursor] != null && tab[cursor].key != key) {
            --cursor;
        }
        tab[cursor] = new Node<>(key, value);

        // 将碰撞节点指向这个新节点
        while (tab[idx].idxOfNext != 0) {
            idx = tab[idx].idxOfNext;
        }

        tab[idx].idxOfNext = cursor;
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        while (tab[idx].key != key) {
            idx = tab[idx].idxOfNext;
        }
        return tab[idx].value;
    }

    static class Node<K, V> {
        final K key;
        V value;
        int idxOfNext;

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

        public int getIdxOfNext() {
            return idxOfNext;
        }

        public void setIdxOfNext(int idxOfNext) {
            this.idxOfNext = idxOfNext;
        }

    }

    @Override
    public String toString() {
        return "HashMap{" +
                "tab=" + JSON.toJSONString(tab) +
                '}';
    }

}