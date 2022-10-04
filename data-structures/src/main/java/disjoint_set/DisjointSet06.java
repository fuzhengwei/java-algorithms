package disjoint_set;

import java.util.Arrays;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DisjointSet06 extends AbstractDisjointSet implements IDisjointSet {

    public int[] rank;

    public DisjointSet06(int size) {
        items = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            items[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public int find(int i) {
        if (i < 0 || i >= items.length)
            throw new IllegalArgumentException("Index out of range.");

        if (i != items[i]) {
            // 递归
            return find(items[i]);
        }

        return items[i];
    }

    @Override
    public void union(int parent, int child) {
        // 父亲节点的根节点下标值
        int parentRootIdx = find(parent);
        // 孩子节点的根节点下标值
        int childRootIdx = find(child);

        if (parentRootIdx == childRootIdx)
            return;

        if (rank[parentRootIdx] > rank[childRootIdx]) {
            items[childRootIdx] = items[parentRootIdx];
        } else if (rank[parentRootIdx] < rank[childRootIdx]) {
            items[parentRootIdx] = items[childRootIdx];
        } else {
            items[childRootIdx] = items[parentRootIdx];
            rank[parentRootIdx]++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("坐标 | ");
        for (int i = 0; i < items.length; i++) {
            builder.append(i);
            builder.append(" | ");
        }
        builder.append("\n");
        builder.append("-----------------------------------------");
        builder.append("\n");
        builder.append("排序 | ");
        for (int i = 0; i < rank.length; i++) {
            builder.append(rank[i]);
            builder.append(" | ");
        }
        builder.append("\n");
        builder.append("-----------------------------------------");
        builder.append("\n");
        builder.append("指向 | ");
        for (int i = 0; i < items.length; i++) {
            builder.append(items[i]);
            builder.append(" | ");
        }
        builder.append("\n");
        return builder.toString();
    }

}