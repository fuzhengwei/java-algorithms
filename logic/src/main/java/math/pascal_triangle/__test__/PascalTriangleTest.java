package math.pascal_triangle.__test__;

import com.alibaba.fastjson.JSON;
import math.factorial.__test__.FactorialTest;
import math.pascal_triangle.PascalTriangle;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PascalTriangleTest {

    private final Logger logger = LoggerFactory.getLogger(PascalTriangleTest.class);

    @Test
    public void test_PascalTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        for (int i = 0; i <= 10; i++) {
            HashMap<Integer, Integer> currentLineMap = pascalTriangle.pascalTriangle(i);
            System.out.println(JSON.toJSONString(currentLineMap.values()));
        }
    }

    /**
     * 通过杨辉三角公式计算组合数 c(n,k) = n!/k!(n-k)!
     */
    @Test
    public void combination() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        long combination = pascalTriangle.combination(5, 3);
        logger.info("测试结果：" + combination);
    }

}
