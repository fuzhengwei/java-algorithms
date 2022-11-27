package math.euclidean.__test__;

import math.euclidean.Euclidean;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class EuclideanTest {

    @Test
    public void test_euclidean() {
        Euclidean euclidean = new Euclidean();
        System.out.println(euclidean.gcd01(124, 20));
        System.out.println(euclidean.gcd02(124, 20));
    }

}
