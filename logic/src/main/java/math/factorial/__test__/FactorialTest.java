package math.factorial.__test__;

import math.factorial.Factorial;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {

    private final Logger logger = LoggerFactory.getLogger(FactorialTest.class);

    @Test
    public void test() {
        Factorial factorial = new Factorial();
        long result = factorial.factorial(5);
        System.out.println("测试结果：" + result);
    }

}
