package disjoint_set;

/**
 * @author 小傅哥，微信：fustack
 * @description 并查集
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DisjointSet01 extends AbstractDisjointSet implements IDisjointSet {

    public DisjointSet01(int size) {
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
        if (i < 0 || i >= items.length) throw new IllegalArgumentException("Index out of range.");
        return items[i];
    }

    @Override
    public void union(int parent, int child) {
        int parentVal = find(parent);
        int childVal = find(child);

        if (parentVal == childVal) return;

        for (int i = 0; i < items.length; i ++){
            // 所有值等于原孩子节点对应值的都替换为新的父节点值
            if (items[i] == childVal){
                items[i] = parentVal;
            }
        }
    }

}
