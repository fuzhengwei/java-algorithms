package math.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

    public double fibonacci(int n) {
        double currentVal = 1;
        double previousVal = 0;

        if (n == 1) return 1;

        int iterationsCounter = n - 1;
        while (iterationsCounter > 0) {
            currentVal += previousVal;
            previousVal = currentVal - previousVal;

            iterationsCounter -= 1;
        }
        return currentVal;
    }

    public int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2));
        }
    }

    /**
     * @see：https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression
     */
    public double fibonacciClosedForm(long position) {
        int maxPosition = 75;
        if (position < 1 || position > maxPosition) {
            throw new RuntimeException("Can't handle position smaller than 1 or greater than 75");
        }
        double sqrt = Math.sqrt(5);
        double phi = (1 + sqrt) / 2;
        return Math.floor((Math.pow(phi, position)) / sqrt + 0.5);
    }

    public Map<Integer, Map<Integer, Integer>> hashFunction(int dbCount, int tbCount, Long hashIncrementVal, int hashType) {
        int size = dbCount * tbCount;
        System.out.print("库数：" + dbCount + " 表数：" + tbCount + " 总值：" + size + " 幂值：" + Math.log(size) / Math.log(2));

        int HASH_INCREMENT = (int) ((null == hashIncrementVal ? size : hashIncrementVal) * (Math.sqrt(5) - 1) / 2);
        System.out.print(" 黄金分割：" + HASH_INCREMENT + "/" + size + " = " + (double) HASH_INCREMENT / size);

        Map<Integer, Map<Integer, Integer>> map = new ConcurrentHashMap<>();
        Set<String> words = FileUtil.readWordList("/Users/fuzhengwei/1024/github/java-algorithms/logic/src/main/java/math/fibonacci/103976个英语单词库.txt");
        System.out.println(" 单词总数：" + words.size() + "\r\n");

        for (String word : words) {
            int idx = 0;
            switch (hashType) {
                // 散列：斐波那契散列  int idx = (size - 1) & (word.hashCode() * HASH_INCREMENT + HASH_INCREMENT);
                case 0:
                    idx = (word.hashCode() * HASH_INCREMENT) & (size - 1);
                    break;
                // 散列：哈希散列 + 扰动函数
                case 1:
                    idx = (size - 1) & (word.hashCode() ^ (word.hashCode() >>> 16));
                    break;
                // 散列：哈希散列
                case 2:
                    idx = (size - 1) & (word.hashCode()/* ^ (word.hashCode() >>> 16)*/);
                    break;
                // 散列：整数求模
                case 3:
                    idx = Math.abs(word.hashCode()) % size;
                    break;
            }

            // 计算路由索引
            int dbIdx = idx / tbCount + 1;
            int tbIdx = idx - tbCount * (dbIdx - 1);

            // 保存路由结果
            if (map.containsKey(dbIdx)) {
                Map<Integer, Integer> dbCountMap = map.get(dbIdx);
                if (dbCountMap.containsKey(tbIdx)) {
                    dbCountMap.put(tbIdx, dbCountMap.get(tbIdx) + 1);
                } else {
                    dbCountMap.put(tbIdx, 1);
                }
            } else {
                Map<Integer, Integer> dbCountMap = new HashMap<>();
                dbCountMap.put(tbIdx, 1);
                map.put(dbIdx, dbCountMap);
            }
        }

        return map;
    }

}
