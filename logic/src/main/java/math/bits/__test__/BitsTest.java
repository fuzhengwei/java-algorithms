package math.bits.__test__;

import math.bits.Bits;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitsTest {

    private final Logger logger = LoggerFactory.getLogger(BitsTest.class);

    private final Bits bits = new Bits();

    @Test
    public void test_binary_arithmetic() {
        int a = 1; // 0001
        int b = 2; // 0010
        int c = 4; // 0100
        int d = 8; // 1000
        int e = 15;// 1111

        // 与运算；两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
        System.out.println(Integer.toBinaryString(a & e)); // 0001
        // 或运算；两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
        System.out.println(Integer.toBinaryString(a | b)); // 0011
        // 非运算；两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
        System.out.println(Integer.toBinaryString(a ^ c)); // 0101
        // 异或运算；如果位为0，结果是1，如果位为1，结果是0
        System.out.println(Integer.toBinaryString(~d));      // ...11110111
    }

    @Test
    public void test_exchange() {
        int a = 2, b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void test_getBit() {
        int number = 6;
        int bitPosition = 2;
        int bit = bits.getBit(number, bitPosition);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number) + "、bitPosition = " + bitPosition);
        System.out.println("测试结果：" + Integer.toBinaryString(bit));
    }

    @Test
    public void test_setBit() {
        int number = 4;
        int bitPosition = 1;
        int bit = bits.setBit(number, bitPosition);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number) + "、bitPosition = " + bitPosition);
        System.out.println("测试结果：" + Integer.toBinaryString(bit));
    }

    @Test
    public void test_clearBit() {
        int number = 15;
        int bitPosition = 2;
        int bit = bits.clearBit(number, bitPosition);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number) + "、bitPosition = " + bitPosition);
        System.out.println("测试结果：" + Integer.toBinaryString(bit));
    }

    @Test
    public void test_updateBit() {
        int number = 11;
        int bitPosition = 2;
        int bit = bits.updateBit(number, bitPosition, 1);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number) + "、bitPosition = " + bitPosition);
        System.out.println("测试结果：" + Integer.toBinaryString(bit));
    }

    @Test
    public void test_isEven() {
        int number = 15;
        boolean bit = bits.isEven(number);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number));
        System.out.println("测试结果：" + (bit ? "偶数" : "奇数"));
    }

    @Test
    public void test_isPositive() {
        System.out.println(Integer.toBinaryString(-15 >> 31));
        int number = -15;
        boolean bit = bits.isPositive(number);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number));
        System.out.println("测试结果：" + (bit ? "正数" : "负数"));
    }

    @Test
    public void test_multiplyByTwo() {
        int number = 1;
        int bit = bits.multiplyByTwo(number);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number));
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_divideByTwo() {
        int number = 1;
        int bit = bits.divideByTwo(number);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number));
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_switchSign() {
        int number = -8;
        System.out.println(Integer.toBinaryString(~8));
        int bit = bits.switchSign(number);
        System.out.println("入参信息：number = " + Integer.toBinaryString(number));
        System.out.println("测试结果：" + bit + " = " + Integer.toBinaryString(bit));
    }

    @Test
    public void test_multiply() {
        int a = 2;
        int b = 7;
        int bit = bits.multiply(a, b);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_multiplyUnsigned() {
        int a = 2;
        int b = 13;
        System.out.println("入参信息：a = " + a + " b = " + b);
        int bit = bits.multiplyUnsigned(a, b);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_countSetBits() {
        int originalNumber = 14;
        System.out.println("入参信息：originalNumber = " + Integer.toBinaryString(originalNumber));
        int bit = bits.countSetBits(originalNumber);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_bitsDiff() {
        int a = 15;
        int b = 3;
        System.out.println("入参信息：a = " + Integer.toBinaryString(a) + " b = " + Integer.toBinaryString(b));
        int bit = bits.bitsDiff(a, b);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_bitLength() {
        int originalNumber = 14;
        System.out.println("入参信息：originalNumber = " + Integer.toBinaryString(originalNumber));
        int bit = bits.bitLength(originalNumber);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_isPowerOfTwo() {
        int originalNumber = 7;
        System.out.println("入参信息：originalNumber = " + Integer.toBinaryString(originalNumber));
        boolean bit = bits.isPowerOfTwo(originalNumber);
        System.out.println("测试结果：" + bit);
    }

    @Test
    public void test_fullAdder() {
        int a = 3;
        int b = 6;
        System.out.println("入参信息：a = " + a + " b = " + b);
        int bit = bits.fullAdder(a, b);
        System.out.println("测试结果：" + bit);
    }

}
