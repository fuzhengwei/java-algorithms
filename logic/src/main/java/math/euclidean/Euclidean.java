package math.euclidean;

/**
 * @author 小傅哥，微信：fustack
 * @description 欧几里德算法 辗转相除法（欧几里得算法）计算最大公约数
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Euclidean {

    public long gcd01(long m, long n) {
        m = Math.abs(m);
        n = Math.abs(n);
        // 从一个数字中减去另一个数字，直到两个数字变得相同。
        // 这将是 GCD。如果其中一个数字为零，也退出循环。
        // https://en.wikipedia.org/wiki/Euclidean_algorithm
        while (m != 0 && n != 0 && m != n) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        return m == 0 ? n : m;
    }

    public long gcd02(long m, long n) {
        if (m < n) {
            long k = m;
            m = n;
            n = k;
        }
        if (m % n != 0) {
            long temp = m % n;
            return gcd02(n, temp);
        } else {
            return n;
        }
    }

}
