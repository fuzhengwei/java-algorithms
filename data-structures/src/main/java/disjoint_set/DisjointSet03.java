package disjoint_set;

import java.util.Arrays;

/**
 * @author 小傅哥，微信：fustack
 * @description 并查集
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DisjointSet03 extends AbstractDisjointSet implements IDisjointSet {

    public int[] count;

    public DisjointSet03(int size) {
        items = new int[size];
        count = new int[size];
        for (int i = 0; i < size; i++) {
            items[i] = i;
        }
        Arrays.fill(count, 1);
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public int find(int i) {
        if (i < 0 || i >= items.length)
            throw new IllegalArgumentException("Index out of range.");

        // 找到元素的根节点，当i == item[i]，就是自己指向自己，这个节点就是根节点
        while (i != items[i]) {
            i = items[i];
        }

        return i;
    }

    @Override
    public void union(int parent, int child) {
        // 父亲节点的根节点下标值
        int parentRootIdx = find(parent);
        // 孩子节点的根节点下标值
        int childRootIdx = find(child);

        if (parentRootIdx == childRootIdx) return;

        if (count[parentRootIdx] >= count[childRootIdx]) {
            items[childRootIdx] = items[parentRootIdx];
            count[parentRootIdx] += count[childRootIdx];
        } else {
            items[parentRootIdx] = items[childRootIdx];
            count[childRootIdx] += count[parentRootIdx];
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
        builder.append("数量 | ");
        for (int i = 0; i < count.length; i++) {
            builder.append(count[i]);
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
