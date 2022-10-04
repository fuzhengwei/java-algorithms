package disjoint_set;

/**
 * @author 小傅哥，微信：fustack
 * @description 并查集
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DisjointSet02 extends AbstractDisjointSet implements IDisjointSet {

    public DisjointSet02(int size) {
        items = new int[size];
        for (int i = 0; i < size; i++) {
            items[i] = i;
        }
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

        // 孩子节点值替换为父节点值
        items[childRootIdx] = items[parentRootIdx];
    }

}