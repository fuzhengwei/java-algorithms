package math.radian.__test__;

import math.radian.Radian;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 弧度测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class RadianTest {

    private Radian radian = new Radian();

    @Test
    public void test_degreeToRadian() {
        double v = radian.degreeToRadian(24);
        System.out.println("测试结果：" + v);
    }

    @Test
    public void test_radianToDegree() {
        double v = radian.radianToDegree(180);
        System.out.println("测试结果：" + v);
    }

}
