package sets.cartesian_product.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import sets.cartesian_product.CartesianProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class CartesianProductTest {

    @Test
    public void test_CartesianProduct() {
        List<Object> setA = new ArrayList<>();
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");
        setA.add("6");
        setA.add("7");
        setA.add("8");
        setA.add("9");
        setA.add("10");
        setA.add("J");
        setA.add("Q");
        setA.add("K");
        setA.add("A");
        setA.add("2");

        List<Object> setB = new ArrayList<>();
        setB.add("♠");
        setB.add("♥");
        setB.add("♦");
        setB.add("♣");

        List<List<Object>> lists = CartesianProduct.cartesianProduct(setA, setB);
        for (List<Object> objects : lists) {
            System.out.println(JSON.toJSONString(objects));
        }

    }

}
