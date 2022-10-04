package bloom_filter;

import java.util.BitSet;

/**
 * @author 小傅哥，微信：fustack
 * @description 布隆过滤器
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class BloomFilter {

    private static final HashGenerator.HashGroup[] GROUPS = new HashGenerator.HashGroup[]{HashGenerator.HashGroup.G1, HashGenerator.HashGroup.G2, HashGenerator.HashGroup.G3, HashGenerator.HashGroup.G4};

    private final BitSet bits;

    private HashGenerator[] generators;

    public BloomFilter(int size, int[] seeds) {
        bits = new BitSet(size);
        generators = new HashGenerator[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            generators[i] = new HashGenerator(size, seeds[i], GROUPS[i % GROUPS.length]);
        }
    }

    /**
     * 存放元素
     */
    public void add(String value) {
        for (HashGenerator generator : generators) {
            int hash = generator.doHash(value);
            bits.set(hash, true);
        }
    }

    /**
     * 对比元素
     */
    public boolean contains(String value) {
        boolean ret = true;
        for (HashGenerator generator : generators) {
            ret = ret && bits.get(generator.doHash(value));
        }
        return ret;
    }

    /**
     * 哈希工具
     */
    public static class HashGenerator {

        private int size;
        private int seed;
        private HashGroup group;

        enum HashGroup {
            G1, G2, G3, G4
        }

        public HashGenerator(int size, int seed, HashGroup group) {
            this.size = size;
            this.seed = seed;
            this.group = group;
        }

        public int doHash(String value) {
            switch (group) {
                case G1:
                    return hashG1(value);
                case G2:
                    return hashG2(value);
                case G3:
                    return hashG3(value);
                case G4:
                    return hashG4(value);
                default:
                    throw new RuntimeException("Err HashGroup Is Null!");
            }
        }

        private int hashG1(String value) {
            int hash = 0;
            for (int idx = 0; idx < value.length(); idx++) {
                char c = value.charAt(idx);
                hash = (hash << 5) + hash + c;
                hash &= hash;
                hash = Math.abs(hash);
            }
            return hash % (seed * size - 1);
        }

        private int hashG2(String value) {
            int hash = 7397;
            for (int idx = 0; idx < value.length(); idx++) {
                char c = value.charAt(idx);
                hash = (hash << 5) + hash + c;
            }
            return Math.abs(hash % seed * (size - 1));
        }

        private int hashG3(String value) {
            int hash = 0;
            for (int idx = 0; idx < value.length(); idx++) {
                char c = value.charAt(idx);
                hash = (hash << 5) + hash + c;
                hash += c;
                hash &= hash;
            }
            return Math.abs(hash % (seed * size - 1));
        }

        private int hashG4(String value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (size - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

}
