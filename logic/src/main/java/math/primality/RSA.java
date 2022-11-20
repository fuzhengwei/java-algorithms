package math.primality;

import java.math.BigInteger;

public class RSA {

    /**
     * 判断是否为素数
     */
    public boolean isPrime(long number) {
        boolean isPrime = number > 0;
        // 计算number的平方根为k，可以减少一半的计算量
        int k = (int) Math.sqrt(number);
        for (int i = 2; i <= k; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public long n(long p, long q) {
        return p * q;
    }

    /**
     * 根据欧拉函数，计算互为质数的数量
     * φ(n)=(p-1)(q-1)
     */
    public long euler(long p, long q) {
        return (p - 1) * (q - 1);
    }

    /**
     * 通过辗转相除法（欧几里得算法）计算最大公约数
     */
    public long gcd(long m, long n) {
        if (m < n) {
            long k = m;
            m = n;
            n = k;
        }
        if (m % n != 0) {
            long temp = m % n;
            return gcd(n, temp);
        } else {
            return n;
        }
    }

    public long e(long euler){
        long e = euler / 10;
        while (gcd(e, euler) != 1){
            e ++;
        }
        return e;
    }

    /**
     * 求e模(p-1)*(q-1)的逆，记作d
     * d = (φ(n) + 1)/e
     */
    public long inverse(long e, long euler) {
        return (euler + 1) / e;
    }

    /**
     * c = m^e mod n
     */
    public long encrypt(long m, long e, long n) {
        BigInteger bM = new BigInteger(String.valueOf(m));
        BigInteger bE = new BigInteger(String.valueOf(e));
        BigInteger bN = new BigInteger(String.valueOf(n));
        return Long.parseLong(bM.modPow(bE, bN).toString());
    }

    /**
     * m = c^d mod n
     */
    public long decrypt(long c, long d, long n) {
        BigInteger bC = new BigInteger(String.valueOf(c));
        BigInteger bD = new BigInteger(String.valueOf(d));
        BigInteger bN = new BigInteger(String.valueOf(n));
        return Long.parseLong(bC.modPow(bD, bN).toString());
    }

}