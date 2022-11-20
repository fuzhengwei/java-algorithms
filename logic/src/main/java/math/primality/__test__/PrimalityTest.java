package math.primality.__test__;

import math.primality.Primality;
import math.primality.RSA;
import org.junit.jupiter.api.Test;

public class PrimalityTest {

    @Test
    public void test_primality() {
        Primality primality = new Primality();
        for (int i = 0; i < 20; i++) {
            boolean prime = primality.isPrime(i);
            if (prime) {
                System.out.println("素数：" + i);
            }
        }
    }

    @Test
    public void test_rsa() {
        RSA rsa = new RSA();

        long p = 3,                         // 选取2个互为质数的p、q
                q = 11,                     // 选取2个互为质数的p、q
                n = rsa.n(p, q),            // n = p * q
                euler = rsa.euler(p, q),    // euler = (p-1)*(q-1)
                e = rsa.e(euler),           // 互为素数的小整数e | 1 < e < euler
                d = rsa.inverse(e, euler),  // ed = φ(n) + 1 | d = (φ(n) + 1)/e
                msg = 5;                    // 传递消息 5

        System.out.println("消息：" + msg);
        System.out.println("公钥(n,e)：" + "(" + n + "," + e + ")");
        System.out.println("私钥(n,d)：" + "(" + n + "," + d + ")");

        long encrypt = rsa.encrypt(msg, e, n);
        System.out.println("加密（消息）：" + encrypt);

        long decrypt = rsa.decrypt(encrypt, d, n);
        System.out.println("解密（消息）：" + decrypt);

    }

}
