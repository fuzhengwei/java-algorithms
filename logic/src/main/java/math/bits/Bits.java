package math.bits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bits {

    private final Logger logger = LoggerFactory.getLogger(Bits.class);

    /**
     * 获取二进制数字，指定位置的值
     * 1. 该方法向右移动目标位到最右边，即位数组的第0个位置上。
     * 2. 然后在该数上与形如 0001 的二进制形式的数进行AND操作。
     * 3. 这会清理掉除了目标位的所有其它位的数据。
     * 4. 如果目标位是1，那么结果就是1，反之，结果是0;
     */
    public int getBit(int number, int bitPosition) {
        return (number >> bitPosition) & 1;
    }

    /**
     * 1. 该方法把1向左移动了bitPosition位，生成了一个二进制形如00100的值。
     * 2. 然后我们拿该值与目标数字进行OR操作，就能把目标位设置位1而不影响其它位。
     */
    public int setBit(int number, int bitPosition) {
        return number | (1 << bitPosition);
    }

    /**
     * 1. 该方法把1向左移动了bitPosition位，生成了一个二进制形如00100的值。
     * 2. 然后反转每一位的数字，得到一个二进制形如11011的值。接着与目标值进行AND操作，就能清除掉目标位的值。
     */
    public int clearBit(int number, int bitPosition) {
        int mask = ~(1 << bitPosition);
        return number & mask;
    }

    /**
     * 该方法组合了“Clear Bit”和“Set Bit”
     */
    public int updateBit(int number, int bitPosition, int bitValue) {
        int clearMask = ~(1 << bitPosition);
        return (number & clearMask) | (bitValue << bitPosition);
    }

    /**
     * 该方法检测传入的number是否是偶数。它的实现基于奇数的最右边的位永远是1这个事实。
     */
    public boolean isEven(int number) {
        return (number & 1) == 0;
    }

    /**
     * 该方法检测传入的number是否是正数。
     * 它的实现基于正数最左边的位永远是0这个事实。然而如果传入的number是0或者-0，它也应该返回false。
     */
    public boolean isPositive(int number) {
        if (number == 0) {
            return false;
        }
        return ((number >> 31) & 1) == 0;
    }

    /**
     * 该方法将原始数字向左移动一位。因此所有位都将乘以2，因此数字本身也将乘以2。
     */
    public int multiplyByTwo(int number) {
        return number << 1;
    }

    /**
     * 该方法将原始数字向右移动一位。因此所有位都将除以2，因此数字本身也将除以2,且不会产生余数。
     */
    public int divideByTwo(int number) {
        return number >> 1;
    }

    /**
     * 该方法将正数变成负数，反之亦然。为了做到这一点，它使用了“二进制补码”的方法，即取反所有位然后加1.
     */
    public int switchSign(int number) {
        return ~number + 1;
    }

    /**
     * 该方法使用位运算符计算两个有符号数的乘积。具体步骤；
     * a * b 可以被改写成如下形式：这样转换的优势在于，递归的每一步，递归的操作数的值都减少了一半。因此，运行时的时间复杂度为O(log(b)),其中b是在每个递归步骤上减少为一半的操作数。
     * 0                     a为0，b为0，或者a，b都为0
     * 2a * (b/2)            b是偶数
     * 2a * (b - 1)/2 + a    b是奇数，正数
     * 2a * (b + 1)/2 - a    b是奇数，负数
     * <p>
     * 计算过程；
     * 1. 当a的值左移，b的值右移，b归0时，a的值左移累计下来的结果就是乘积总和。
     * 2. b = 1000 右移到最后一定是奇数，奇数用于累计a的结果
     */
    public int multiply(int a, int b) {
        int multiply = 0;
        while (a != 0 && b != 0) {
            System.out.print("计算步骤(" + (isEven(b) ? "偶数" : "奇数") + ")：a(" + String.format("%04d", Integer.valueOf(Integer.toBinaryString(a))) + ") = " + a + " | b(" + String.format("%04d", Integer.valueOf(Integer.toBinaryString(b))) + ") = " + b);
            // b 是偶数：2a * (b/2)
            if (isEven(b)) {
                a = multiplyByTwo(a);
                b = divideByTwo(b);
            }
            // b 奇数
            else {
                // b 正数：2a * (b - 1)/2 + a
                if (isPositive(b)) {
                    multiply += a;
                    a = multiplyByTwo(a);
                    b = divideByTwo(b - 1);
                }
                // b 负数：2a * (b + 1)/2 - a
                else {
                    multiply -= a;
                    a = multiplyByTwo(a);
                    b = divideByTwo(b + 1);
                }
            }
            System.out.println(" | multiply(" + String.format("%04d", Integer.valueOf(Integer.toBinaryString(multiply))) + ") = " + multiply);
        }
        return multiply;
    }

    /**
     * 乘机计算，递归实现
     */
    public int multiplyByRecursive(int a, int b) {
        if (b == 0 || a == 0) {
            return 0;
        }
        return isEven(b) ?
                multiply(multiplyByTwo(a), divideByTwo(b)) :
                (isPositive(b) ? multiply(multiplyByTwo(a), divideByTwo(b - 1)) + a : multiply(multiplyByTwo(a), divideByTwo(b + 1)) - a);
    }

    /**
     * 该方法使用位运算符计算两个无符号数的乘积。实现基于“每个数字都可以表示为一系列2的幂的和”。
     * 逐位乘法的主要思想是，每个数字都可以拆分为两个乘方的和：
     * 13 = 2^3 + 2^2 + 2^0
     * x*13 = x*2^3 + x*2^2 + x*2^0
     * x*13 = x<<3 + x<<2 + x<<0
     * 2*13 = 2<<3 + 2<<2 + 2<<0
     * = 16 + 8 + 2
     * = 26
     */
    public int multiplyUnsigned(int number1, int number2) {
        int result = 0;
        int multiplier = number2;
        int bitIdx = 0;

        while (multiplier != 0) {

            if ((multiplier & 1) == 1) {
                System.out.println(number1 + " << " + bitIdx + " = " + (number1 << bitIdx));
                result += number1 << bitIdx;
            }

            bitIdx += 1;
            multiplier = multiplier >> 1;
        }

        return result;
    }

    /**
     * 该方法使用位运算符对一个数字里设置为1的位进行记数。
     * 主要方法是，把数字每次向右移动1位，然后使用&操作符取出最右边一位的值，1则记数加1，0则不计。
     */
    public int countSetBits(int originalNumber) {
        int setBitsCount = 0;
        int number = originalNumber;

        while (number != 0) {
            setBitsCount += number & 1;
            number >>>= 1;
        }

        return setBitsCount;
    }

    /**
     * 该方法输出把一个数字转换为另一个数字所需要转换的位数。
     * 这利用了以下特性：当数字进行XOR异或运算时，结果将是不同位数的数量(即异或的结果中所有被设置为1的位的数量)。
     */
    public int bitsDiff(int number1, int number2) {
        return countSetBits(number1 ^ number2);
    }

    /**
     * 为了计算数字的有效位数，我们需要把1每次向左移动一位，然后检查产生的值是否大于输入的数字。
     */
    public int bitLength(int number) {
        int bitsCounter = 0;
        while ((1 << bitsCounter) <= number) {
            bitsCounter += 1;
        }
        return bitsCounter;
    }

    /**
     * 该方法检测数字是否可以表示为2的幂。它使用了以下特性，我们定义powerNumber是可以写成2的幂的形式的数(2,4,8,16 etc.)。
     * 然后我们会把powerNumber和powerNumber - 1进行&操作，它会返回0(如果该数字可以表示为2的幂)。
     */
    public boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0;
    }

    /**
     * 该方法使用位运算符计算两个数的和。
     * 它实现了完整的加法器电子电路逻辑，以补码的形式计算两个32位数字的和。
     * 它使用布尔逻辑来覆盖了两个位相加的所有情况：从前一位相加的时候，产没产生进位“carry bit”。
     * <p>
     * A: 数字 A
     * B: 数字 B
     * ai: 数字A以二进制表示时的位下标
     * bi: 数字B以二进制表示时的位下标
     * carryIn: 本次计算产生的进位
     * carryOut: 带入此次计算的进位
     * bitSum: ai, bi, 和 carryIn 的和
     * resultBin: 当前计算的结果（二进制形式）
     * resultDec: 当前计算的结果（十进制形式）
     * <p>
     * A = 3: 011
     * B = 6: 110
     * ┌──────┬────┬────┬─────────┬──────────┬─────────┬───────────┬───────────┐
     * │  bit │ ai │ bi │ carryIn │ carryOut │  bitSum │ resultBin │ resultDec │
     * ├──────┼────┼────┼─────────┼──────────┼─────────┼───────────┼───────────┤
     * │   0  │ 1  │ 0  │    0    │    0     │     1   │       1   │     1     │
     * │   1  │ 1  │ 1  │    0    │    1     │     0   │      01   │     1     │
     * │   2  │ 0  │ 1  │    1    │    1     │     0   │     001   │     1     │
     * │   3  │ 0  │ 0  │    1    │    0     │     1   │    1001   │     9     │
     * └──────┴────┴────┴─────────┴──────────┴─────────┴───────────┴───────────┘
     */
    public int fullAdder(int a, int b) {
        int result = 0;
        // 计算每次的进位值，1 + 1 = 0010 进位为1。是一种&运算。
        int carryOut = 0;
        System.out.println("| aBit | bBit | carryIn | aiPlusBi | bitSum | carryOut | result |");
        for (int i = 0; i < 32; i++) {
            int aBit = getBit(a, i);
            int bBit = getBit(b, i);
            int carryIn = carryOut;
            System.out.print("|   " + aBit + "  |  " + bBit + "   |       " + carryIn);

            // 加和 - 两个值；如果相同则为0，不相同则为1
            int aiPlusBi = aBit ^ bBit;
            System.out.print(" |        " + aiPlusBi);

            // 加和 - 进位；
            int bitSum = aiPlusBi ^ carryIn;
            System.out.print(" |      " + bitSum);

            // 进位；同位置 ai & bi = 1 | 与进位 aiPlusBi & carryIn = 1
            carryOut = (aBit & bBit) | (aiPlusBi & carryIn);
            System.out.print(" |  " + carryOut + "(" + Integer.toBinaryString(carryOut) + ")   ");

            // 累加；把当前位置计算的值，左移n位
            result = result | (bitSum << i);
            System.out.println(" | " + result + "(" + String.format("%04d", Integer.valueOf(Integer.toBinaryString(result))) + ")|");
        }

        return result;
    }

}
