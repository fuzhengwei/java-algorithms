package math.sieve_of_eratosthenes;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author 小傅哥，微信：fustack
 * @description 素数筛 https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SieveOfEratosthenes {

    public List<Integer> sieveOfLinear(int maxNumber) {
        // 方便打印结果，可删除此代码
        Map<Integer, List<Integer>> primesMap = new HashMap<>();

        List<Integer> isPrime = new ArrayList<>(maxNumber + 1);
        isPrime.add(0);
        isPrime.add(1);

        List<Integer> primes = new ArrayList<>();
        for (int number = 2; number < maxNumber; number++) {
            if (!isPrime.contains(number)) {
                primes.add(number);
                // 方便打印结果，可删除此代码
                primesMap.put(number, new ArrayList<>());
            }
            for (int i = 0; i < primes.size() && primes.get(i) <= maxNumber / number; i ++) {
                isPrime.add(primes.get(i) * number);
                primesMap.get(primes.get(i)).add(primes.get(i) * number);
                if (number % primes.get(i) == 0) {
                    break;
                }
            }
        }
        System.out.println("筛选素数过程");
        for (Integer key : primesMap.keySet()) {
            System.out.println(key + "：" + JSON.toJSONString(primesMap.get(key)));
        }
        return primes;
    }


    public List<Integer> sieveOfEratosthenes(int maxNumber) {
        // 方便打印结果，可删除此代码
        Map<Integer, List<Integer>> primesMap = new HashMap<>();

        List<Integer> isPrime = new ArrayList<>(maxNumber + 1);
        isPrime.add(0);
        isPrime.add(1);

        List<Integer> primes = new ArrayList<>();
        /*
         * 从“p*p”开始标记“p”的倍数，而不是从“2*p”开始。
         * 这之所以有效，是因为在这一点上，较小的倍数
         * “p”的将已标记为“false”。
         *
         * 警告：当处理非常大的数字时，以下行可能会导致溢出
         * 在这种情况下，可以将其更改为：
         * *让nextNumber=2*number；
         */
        for (int number = 2; number < maxNumber; number++) {
            if (!isPrime.contains(number)) {
                primes.add(number);
                // 方便打印结果，可删除此代码
                primesMap.put(number, new ArrayList<>());

                int nextNumber = number * number;
                while (nextNumber <= maxNumber) {
                    // 方便打印结果，可删除此代码
                    primesMap.get(number).add(nextNumber);
                    isPrime.add(nextNumber);
                    nextNumber += number;
                }
            }
        }

        System.out.println("筛选素数过程");
        for (Integer key : primesMap.keySet()) {
            System.out.println(key + "：" + JSON.toJSONString(primesMap.get(key)));
        }

        return primes;

    }

}
