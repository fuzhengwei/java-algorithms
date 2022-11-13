package math.fibonacci.__test__;

import math.fibonacci.Fibonacci;
import math.fibonacci.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    public void test_fibonacci() {
        double result = fibonacci.fibonacci(10);
        System.out.println(result);
    }

    @Test
    public void test_fibonacciRecursion() {
        int result = fibonacci.fibonacciRecursion(10);
        System.out.println(result);
    }

    @Test
    public void test_fibonacciClosedForm() {
        double result = fibonacci.fibonacciClosedForm(71);
        System.out.println(result);
    }

    @Test
    public void test_hashFunction_0_hash_null() {
        Map<Integer, Map<Integer, Integer>> map = fibonacci.hashFunction(8, 32, null, 0);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Collection<Integer> values = map.get(key).values();
            for (Integer v : values) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_hashFunction_0() {
        Map<Integer, Map<Integer, Integer>> map = fibonacci.hashFunction(9, 32, 1L << 32, 0);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Collection<Integer> values = map.get(key).values();
            for (Integer v : values) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_hashFunction_3() {
        Map<Integer, Map<Integer, Integer>> map = fibonacci.hashFunction(8, 32, null, 3);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Collection<Integer> values = map.get(key).values();
            for (Integer v : values) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_division() {
        Long bugHeap = (1L << 32) - (long) ((1L << 32) * (Math.sqrt(5) - 1)) / 2;
        System.out.println("(1L << 32) - (long) ((1L << 32) * (Math.sqrt(5) - 1))/2:" + bugHeap);
        System.out.println("(1L << 32) - (long) ((1L << 32) * (Math.sqrt(5) - 1))/2:" + Long.toHexString(bugHeap));
    }

    @Test
    public void test_math() {
        System.out.println(Math.log(256) / Math.log(2));
    }

}
