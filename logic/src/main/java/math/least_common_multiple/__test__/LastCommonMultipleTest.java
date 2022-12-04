package math.least_common_multiple.__test__;

import math.least_common_multiple.LastCommonMultiple;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class LastCommonMultipleTest {

    @Test
    public void test_euclidean() {
        LastCommonMultiple lastCommonMultiple = new LastCommonMultiple();

        // System.out.println("最小公倍数：" + lastCommonMultiple.lcm01(2, 7));
        System.out.println("最小公倍数：" + lastCommonMultiple.lcm02(3, 4, 6));
        // System.out.println("最小公倍数：" + lastCommonMultiple.lcm03(3, 4, 6));
         System.out.println("最小公倍数：" + lastCommonMultiple.lcm03(3, 4, 6, 8));
       //System.out.println("最小公倍数：" + lastCommonMultiple.lcm03(4, 7, 12, 21, 42));
    }

}



















