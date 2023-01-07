package math.fast_powering.__test__;

import math.fast_powering.FastPowering;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class FastPoweringTest {

    @Test
    public void test_pow() {
        System.out.println(Math.pow(2, 4));
    }

    @Test
    public void test_FastPowering() {
        System.out.println("测试结果：" + FastPowering.pow01(2, 4));
        System.out.println("测试结果：" + FastPowering.pow02(2, 10));
        System.out.println("测试结果：" + FastPowering.pow03(2, 4));
        System.out.println("测试结果：" + FastPowering.pow04(BigInteger.valueOf(2), BigInteger.valueOf(10)));
        System.out.println("测试结果：" + FastPowering.pow05(BigInteger.valueOf(2), BigInteger.valueOf(10)));
    }

}
