# Java 数据结构和算法

![](/docs/images/background.png?raw=true)

- 本仓库预包含多种基于 Java 的算法与数据结构学习。学习打卡讨论：[discussions](https://github.com/fuzhengwei/java-algorithms/discussions)
- 关注公众号[【bugstack虫洞栈】](https://mp.weixin.qq.com/s/6ro45s4UWar7yt2gXQb5iw)回复【`数据结构`】——领取《倚天村 • 图解数据结构》PDF 方便做笔记学习
- 也欢迎你成为contributors的一员，你可以提交issue、pr，贡献资料（源码 + 文档）**注意和现有风格保持一致**

## 《倚天村 • 图解数据结构》

数据结构是在计算机中组织和存储数据的一种特殊方式，使得数据可以高效地被访问和修改。更确切地说，数据结构是数据值的集合，表示数据之间的关系，也包括了作用在数据上的函数或操作。

`B` - 初学者，`A` - 进阶

### 线性数据结构

- [x] [`B` 链表 Link List](https://bugstack.cn/md/algorithm/data-structures/2022-07-22-linked-list.html)
- [x] [`B` 数组 Array](https://bugstack.cn/md/algorithm/data-structures/2022-07-30-array-list.html)
- [x] [`B` 队列 Query](https://bugstack.cn/md/algorithm/data-structures/2022-08-06-queue.html)
- [x] [`B` 堆栈（栈）Stack](https://bugstack.cn/md/algorithm/data-structures/2022-08-17-stack.html)
- [x] [`B` 哈希表(散列) Hash](https://bugstack.cn/md/algorithm/data-structures/2022-08-27-hash-table.html)

### 树形数据结构

- [x] [`B` 堆 - 最大堆 & 最小堆](https://bugstack.cn/md/algorithm/data-structures/2022-09-03-heap.html)
- [x] [`A` 字典树](https://bugstack.cn/md/algorithm/data-structures/2022-09-14-trie.html)
- [x] 树
  - [x] [`A` 二叉查找树](https://bugstack.cn/md/algorithm/data-structures/2022-09-18-tree.html)
  - [x] [`A` AVL 树](https://bugstack.cn/md/algorithm/data-structures/2022-09-26-tree-avl.html)
  - [x] [`A` 2-3树](https://bugstack.cn/md/algorithm/data-structures/2022-10-01-tree-2-3.html)
  - [x] [`A` 红黑树](https://bugstack.cn/md/algorithm/data-structures/2022-10-02-tree-red-black.html)
  - [ ] [`A` 线段树【欢迎PR】](https://github.com/fuzhengwei/java-algorithms/blob/main/data-structures/src/main/java/tree/SegmentTree.java) - 使用 最小/最大/总和 范围查询示例
  - [ ] [`A` 树状数组【欢迎PR】](https://github.com/fuzhengwei/java-algorithms/blob/main/data-structures/src/main/java/tree/FenwickTree.java) (二叉索引树)

### 图论

- [x] [`A` 图 Graph](https://bugstack.cn/md/algorithm/data-structures/2022-10-03-graph.html)

### 其他

- [x] [`A` 布隆过滤器 Bloom Filter](https://bugstack.cn/md/algorithm/data-structures/2022-10-05-bloom-filter.html)

## 《屠龙村 • 手撕算法逻辑》

算法是如何解决一类问题的明确规范。算法是一组精确定义操作序列的规则。


`B` - 初学者， `A` - 进阶

### 算法主题

- **数学**
  - [x] `B` [位运算](https://bugstack.cn/md/algorithm/logic/math/2022-10-30-bits.html) —— 如何使用二进制计算乘法？
  - [x] `B` [阶乘](https://bugstack.cn/md/algorithm/logic/math/2022-10-30-factorial.html) —— 阶乘的用途是什么？
  - [x] `B` [斐波那契数](https://bugstack.cn/md/algorithm/logic/math/2022-11-05-fibonacci.html) —— 为什么不能用斐波那契散列，做数据库路由算法？
  - [x] `B` [素数检测](https://bugstack.cn/md/algorithm/logic/math/2022-11-20-primality.html) —— 你真的了解 RSA 加密算法吗？
  - [x] `B` [欧几里得算法](https://bugstack.cn/md/algorithm/logic/math/2022-11-28-euclidean.html) —— 如何编码程序计算最大公约数
  - [x] `B` [最小公倍数](https://bugstack.cn/md/algorithm/logic/math/2022-12-04-least-common-multiple.html) —— 你能用几种代码实现出计算公倍数？
  - [x] `B` [素数筛](https://bugstack.cn/md/algorithm/logic/math/2022-12-11-sieve-of-eratosthenes.html)
  - [x] `B` [判断 2 次方数](https://bugstack.cn/md/algorithm/logic/math/2022-12-12-is-power-of-two.html)
  - [x] `B` [杨辉三角形](https://bugstack.cn/md/algorithm/logic/math/2022-12-18-pascal-triangle.html)
  - [x] `B` [弧度和角](https://bugstack.cn/md/algorithm/logic/math/2022-12-23-radian.html)
  - [ ] `B` 快速算次方
  - [ ] `A` 整数拆分
  - [ ] `A` 割圆术
  - [ ] `A` 离散傅里叶变换 

## 资料

- [数据结构术语列表](https://zh.wikipedia.org/wiki/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E6%9C%AF%E8%AF%AD%E5%88%97%E8%A1%A8)
- [javascript数据结构](https://github.com/trekhleb/javascript-algorithms)
- [The Fibonacci Association](https://en.wikipedia.org/wiki/The_Fibonacci_Association)
- [哈希函数](https://en.wikipedia.org/wiki/Hash_function)
- [斐波那契数](https://en.wikipedia.org/wiki/Fibonacci_number#Mathematics)
- [散列函数](https://zh.wikipedia.org/wiki/%E6%95%A3%E5%88%97%E5%87%BD%E6%95%B8)
- [雪崩效应](https://en.wikipedia.org/wiki/Avalanche_effect)
- [Fibonacci Hashing: The Optimization that the World Forgot (or: a Better Alternative to Integer Modulo)](https://probablydance.com/2018/06/16/fibonacci-hashing-the-optimization-that-the-world-forgot-or-a-better-alternative-to-integer-modulo/)
- [斐波那契数](https://en.wikipedia.org/wiki/Fibonacci_number#Relation_to_the_golden_ratio)
- [C++ 中具有面向对象设计模式的数据结构和算法](https://book.huihoo.com/data-structures-and-algorithms-with-object-oriented-design-patterns-in-c++/html/page214.html)
- [RSA加密算法](https://zh.wikipedia.org/wiki/RSA%E5%8A%A0%E5%AF%86%E6%BC%94%E7%AE%97%E6%B3%95)
- [RSA算法背后的数学原理](https://luyuhuang.tech/2019/10/24/mathematics-principle-of-rsa-algorithm.html)
- [莱昂哈德·欧拉](https://en.wikipedia.org/wiki/Leonhard_Euler)
- [欧几里德算法](https://en.wikipedia.org/wiki/Euclidean_algorithm)
- [线性组合](https://en.wikipedia.org/wiki/Linear_combination)
- [贝祖定理](https://en.wikipedia.org/wiki/B%C3%A9zout%27s_identity)
- [What is the most efficient way to calculate the least common multiple of two integers?](https://stackoverflow.com/questions/3154454/what-is-the-most-efficient-way-to-calculate-the-least-common-multiple-of-two-int/3154503#3154503)
- [Least common multiple](https://en.wikipedia.org/wiki/Least_common_multiple)
- [Chebyshev function](https://en.wikipedia.org/wiki/Chebyshev_function)
