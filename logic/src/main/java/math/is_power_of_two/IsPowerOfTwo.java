package math.is_power_of_two;

/**
 * @author 小傅哥，微信：fustack
 * @description 判断数字是否为 2 次方数
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class IsPowerOfTwo {

    /**
     * 通过除以2判断是否为0的方式计算
     */
    public boolean isPowerOfTwo01(int number) {
        if (number < 1) return false;

        int dividedNumber = number;
        while (dividedNumber != 1) {
            if (dividedNumber % 2 != 0) {
                return false;
            }
            dividedNumber = dividedNumber / 2;
        }

        return true;
    }

    /**
     * 通过二进制错位 & 运算判断;
     * http://www.graphics.stanford.edu/~seander/bithacks.html#DetermineIfPowerOf2
     * 无符号整型 v；// 我们想看看 v 是否是 2 的幂
     * 布尔 f；// 结果在这里
     * f = (v & (v - 1)) == 0;
     * 请注意，此处 0 被错误地视为 2 的幂。要解决此问题，请使用：
     * f = v && !(v & (v - 1));
     */
    public boolean isPowerOfTwo02(int number) {
        if (number < 1) return false;
        return (number & (number - 1)) == 0;
    }

    /**
     * 取以2为底的数字的对数，如果你得到一个整数，那么这个数字就是2的幂
     */
    public boolean isPowerOfTwo03(int number) {
        if (number == 0)
            return false;
        // log8 = log2^3 / log2 = 3
        double x = Math.log(number) / Math.log(2);
        // 向上和向下取整的结果判断
        return (int)(Math.ceil(x)) == (int)(Math.floor(x));
    }

    /**
     * 两个数的所有幂只有一个位集。所以数一数。设置位的数量，如果您得到 1，则该数字是2的幂。
     */
    public boolean isPowerOfTwo04(int number){
        int cnt = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                cnt++;
            }
            number = number >> 1;
        }
        return cnt == 1;
    }

}