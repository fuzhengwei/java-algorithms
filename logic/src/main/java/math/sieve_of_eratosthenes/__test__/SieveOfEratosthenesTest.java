package math.sieve_of_eratosthenes.__test__;

import com.alibaba.fastjson.JSON;
import math.sieve_of_eratosthenes.SieveOfEratosthenes;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SieveOfEratosthenesTest {

    @Test
    public void test_SieveOfEratosthenes() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        List<Integer> primes = sieveOfEratosthenes.sieveOfEratosthenes(100);
        System.out.println("素数：" + JSON.toJSONString(primes));
    }

}
