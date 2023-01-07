package math.fast_powering;

import java.math.BigInteger;

public class FastPowering {

    /**
     * odd：x^n = x(x^2)^((n-1)/2)
     * even：x^n = x^2^(n/2)
     */
    public static double pow01(double base, double power) {
        if (power == 0) {
            return 1;
        }

        if (power % 2 == 0) {
            double multiplier = pow01(base, power / 2);
            return multiplier * multiplier;
        }

        double multiplier = pow01(base, Math.floor(power / 2));
        return multiplier * multiplier * base;
    }

    /**
     * 通过二进制的方式判断和移位计算
     * 该算法的时间复杂度是 O(log n)，因此它在计算大数的幂次方时比暴力算法（直接使用乘法循环计算幂次方）更加高效。
     */
    public static long pow02(int base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;

            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    /**
     * 滑动窗口算法；
     * 滑动窗口法是一种用于在一个数列中查找满足某些条件的子序列的算法。它的基本思路是，使用一个指针指向子序列的左端点，然后通过不断移动这个指针来扩展子序列的右端点，直到找到满足条件的子序列为止。
     * 该方法是 2 k元方法的有效变体。
     * 例如，要计算具有二进制展开式 (110 001 110) 2的指数 398，
     * 我们使用 2 k元法算法取长度为 3 的窗口并计算 1、x 3、x 6、x 12、x 24 , x 48 , x 49 , x 98 , x 99 , x 198 , x 199 , x 398。
     * 但是，我们也可以计算 1, x 3 , x 6 , x 12 , x 24 , x 48 , x 96, x 192 , x 199 , x 398，这节省了一次乘法，相当于计算 (110 001 110) 2
     */
    public static long pow03(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        long result = 1;
        long window = base;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= window;
            }
            window *= window;
            exponent >>= 1;
        }
        return result;
    }

    /**
     * 蒙哥马利的梯子技术（Montgomery's ladder technique）是一种在密码学中计算幂次方的算法。它的基本思路是通过不断地进行二次求幂运算来计算高次幂。
     * 蒙哥马利的梯子技术需要使用 BigInteger 类型的数据进行计算。BigInteger 类是 Java 中的一个用于处理任意精度整数的类。
     */
    public static BigInteger pow04(BigInteger x, BigInteger n) {
        BigInteger x1 = x;
        BigInteger x2 = x.multiply(x);
        for (int i = n.bitLength() - 2; i >= 0; i--) {
            if (n.testBit(i)) {
                x1 = x1.multiply(x2);
                x2 = x2.multiply(x2);
            } else {
                x2 = x1.multiply(x2);
                x1 = x1.multiply(x1);
            }
        }
        return x1;
    }

    /**
     * 固定底数指数法（Fixed-base exponentiation）是一种用于快速计算幂次方的算法。它的基本思路是使用预先计算的幂的表来减少求幂的次数。
     */
    public static BigInteger pow05(BigInteger base, BigInteger exponent) {
        int e = exponent.intValue();
        BigInteger result = BigInteger.ONE;
        BigInteger current = base;
        while (e > 0) {
            if ((e & 1) == 1) {
                result = result.multiply(current);
            }
            current = current.multiply(current);
            e >>= 1;
        }
        return result;
    }

}
