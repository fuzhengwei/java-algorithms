package tree;

/**
 * @author 小傅哥，微信：fustack
 * @description 树状数组
 * Fenwick 树或二叉索引树是一种数据结构，可以有效地更新元素并计算数字表中的前缀和。
 * 与数字平面数组相比，Fenwick 树在两个操作之间实现了更好的平衡：元素更新和前缀和计算。在n数字平面数组中，您可以存储元素或前缀和。
 * 第一种情况，计算前缀和需要线性时间；
 * 在第二种情况下，更新数组元素需要线性时间（在这两种情况下，其他操作都可以在常数时间内执行）。
 * Fenwick 树允许及时执行这两个操作O(log n)。这是通过将数字表示为树来实现的，其中每个节点的值是该子树中数字的总和。O(log n)树结构允许仅使用节点访问来执行操作。
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class FenwickTree {
}
