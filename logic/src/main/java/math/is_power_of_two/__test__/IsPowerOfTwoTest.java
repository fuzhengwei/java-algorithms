package math.is_power_of_two.__test__;

import math.is_power_of_two.IsPowerOfTwo;
import org.junit.jupiter.api.Test;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class IsPowerOfTwoTest {

    @Test
    public void test_IsPowerOfTwo(){
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo01(8));
        System.out.println(isPowerOfTwo.isPowerOfTwo02(8));
        System.out.println(isPowerOfTwo.isPowerOfTwo03(163));
        System.out.println(isPowerOfTwo.isPowerOfTwo04(12));
    }

    @Test
    public void test_math(){
        System.out.println(Math.ceil(Math.log(8) / Math.log(2)));
        System.out.println(Math.log(1));
        System.out.println(Math.E);
        System.out.println(Math.pow(Math.E, Math.log(2)));
    }

}
