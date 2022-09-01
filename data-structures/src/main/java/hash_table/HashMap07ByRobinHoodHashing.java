package hash_table;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;

/**
 * 罗宾汉哈希(Robin Hood hashing)是一种基于开放寻址的冲突解决算法；冲突是通过偏向从其“原始位置”（即项目被散列到的存储桶）最远或最长探测序列长度（PSL）的元素的位移来解决的。
 */
public class HashMap07ByRobinHoodHashing<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 8;
    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private Entry[] table;
    private int size;
    private final double loadFactor;

    public HashMap07ByRobinHoodHashing() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap07ByRobinHoodHashing(int initCap, double lf) {
        clear(initCap);
        loadFactor = lf;
    }

    @Override
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        int idx = hash(key);
        System.out.println(key + " " + idx);
        // 元素碰撞检测
        while (table[idx] != null) {
            if (entry.offset > table[idx].offset) {
                // 当前偏移量不止一个，则查看条目交换位置，entry 是正在查看的条目，增加现在搜索的事物的偏移量和 idx
                Entry garbage = table[idx];
                table[idx] = entry;
                entry = garbage;
                idx = increment(idx);
                entry.offset++;
            } else if (entry.offset == table[idx].offset) {
                // 当前偏移量与正在查看的检查键是否相同，如果是则它们交换值，如果不是，则增加 idx 和偏移量并继续
                if (table[idx].key.equals(key)) {
                    // 发现相同值
                    V oldVal = table[idx].value;
                    table[idx].value = value;
                } else {
                    idx = increment(idx);
                    entry.offset++;
                }
            } else {
                // 当前偏移量小于我们正在查看的我们增加 idx 和偏移量并继续
                idx = increment(idx);
                entry.offset++;
            }
        }

        // 已经到达了 null 所在的 idx，将新/移动的放在这里
        table[idx] = entry;
        size++;

        // 超过负载因子扩容
        if (size >= loadFactor * table.length) {
            rehash(table.length * 2);
        }
    }

    public V remove(K key) {
        int idx = hash(key);
        int offset = 0;
        while (table[idx] != null) {
            if (offset > table[idx].offset) {
                return null;
            } else if (offset == table[idx].offset) {
                if (table[idx].key.equals(key)) {
                    V itemVal = table[idx].value;
                    table[idx] = null;
                    size--;
                    idx = increment(idx);
                    while (table[idx] != null && table[idx].offset != 0) {
                        int tempidx = decrement(idx);
                        table[tempidx] = table[idx];
                        table[tempidx].offset = table[idx].offset - 1;
                        table[idx] = null;
                        idx = increment(idx);
                    }
                    return itemVal;
                } else {
                    offset++;
                    idx = increment(idx);
                }
            } else {
                offset++;
                idx = increment(idx);
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        int offset = 0;
        int idx = hash(key);
        while (table[idx] != null) {
            if (offset > table[idx].offset) {
                return null;
            } else if (offset == table[idx].offset) {
                if (table[idx].key.equals(key)) {
                    return table[idx].value;
                } else {
                    offset++;
                    idx = increment(idx);
                }
            } else {
                offset++;
                idx = increment(idx);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void clear(int cap) {
        table = (Entry[]) Array.newInstance(Entry.class, cap);
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() & (table.length - 1);
    }

    private int increment(int idx) {
        idx++;
        return idx == table.length ? 0 : idx;
    }

    private int decrement(int idx) {
        idx--;
        return idx == -1 ? table.length - 1 : idx;
    }

    private void rehash(int newCap) {
        Entry[] oldTable = table;
        clear(newCap);
        for (Entry e : oldTable) {
            // skip nulls
            if (e != null) {
                this.put(e.key, e.value);
            }
        }
    }

    private class Entry {
        K key;
        V value;
        int offset;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
            offset = 0;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getOffset() {
            return offset;
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "tab=" + JSON.toJSONString(table) +
                '}';
    }

}
