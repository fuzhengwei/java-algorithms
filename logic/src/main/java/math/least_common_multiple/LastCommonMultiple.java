package math.least_common_multiple;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author 小傅哥，微信：fustack
 * @description 最小公倍数
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class LastCommonMultiple {

    /**
     * 计算最小公倍数 https://en.wikipedia.org/wiki/Least_common_multiple
     * 公式：lcm(a,b) = |ab| / gcd(a,b)
     */
    public long lcm01(long m, long n) {
        return ((m == 0) || (n == 0)) ? 0 : Math.abs(m * n) / gcd(m, n);
    }

    private long gcd(long m, long n) {
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

    /**
     * https://en.wikipedia.org/wiki/Least_common_multiple
     * 数字累加法-xfg
     * 公式：lcm(a,b) =
     * X (1) = (3, 4, 6)
     * X (2) = (6, 4, 6)
     * X (3) = (6, 8, 6)
     * X (4) = (6, 8, 12) - 通过选择第二个 6
     * X (5) = (9, 8, 12)
     * X (6) = (9, 12, 12)
     * X (7) = (12, 12, 12) 所以 lcm = 12。
     */
    public long lcm02(long... n) {
        long[] cache = n.clone();
        // 以所有数字都相等作为条件
        while (!isEquals(n)) {
            System.out.println(JSON.toJSONString(n));
            long min = n[0];
            int idx = 0;
            for (int i = 0; i < n.length; i++) {
                if (min > n[i]) {
                    min = n[i];
                    idx = i;
                }
            }
            n[idx] = cache[idx] + min;
        }
        return n[0];
    }

    private boolean isEquals(long... n) {
        long e = n[0];
        for (long l : n) {
            if (e != l) {
                return false;
            }
        }
        return true;
    }

    /**
     * 表格计算-xfg
     * ×  ⏐	2	2	3	7
     * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
     * 4  ⏐	2  	1	1	1
     * 7  ⏐	7	7	7	1
     * 12 ⏐	6	3	1	1
     * 21 ⏐	21	21	7	1
     * 42 ⏐	21	21	7	1
     */
    public long lcm03(long... n) {
        Map<Long, List<Long>> keys = new HashMap<>();
        for (long key : n) {
            keys.put(key, new ArrayList<Long>() {{
                add(key);
            }});
        }
        System.out.print("执行表格计算：\r\nx ");
        long primality = 2, cachePrimality = primality, filterCount = 0, lcm = 1;
        // 以所有元素最后一位为1作为条件
        while (filterCount != keys.size()) {
            int refresh = 0;
            filterCount = 0;
            for (Map.Entry<Long, List<Long>> entry : keys.entrySet()) {
                long value = entry.getValue().get(entry.getValue().size() - 1);
                if (value == 1) {
                    filterCount++;
                }
                // 整除处理
                if (value % primality == 0) {
                    entry.getValue().add(value / primality);
                    refresh++;
                } else {
                    entry.getValue().add(value);
                }
            }
            // 刷新除数
            if (refresh == 0) {
                for (Map.Entry<Long, List<Long>> entry : keys.entrySet()) {
                    long value = entry.getValue().get(entry.getValue().size() - 1);
                    // 找到下一个符合的素数
                    if (value > primality || (value < cachePrimality && value > primality)) {
                        cachePrimality = value;
                    }
                    entry.getValue().remove(entry.getValue().size() - 1);
                }
                primality = cachePrimality;
            } else {
                // 累计乘积
                lcm *= cachePrimality;
                System.out.print(cachePrimality + " ");
            }
        }

        keys.forEach((key, values) -> {
            System.out.println();
            for (long v : values) {
                System.out.print(v + " ");
            }
        });
        System.out.println("\r\n");
        return lcm;
    }

}
