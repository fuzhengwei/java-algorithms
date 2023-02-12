package sets.cartesian_product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 笛卡尔积 https://en.wikipedia.org/wiki/Cartesian_product
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class CartesianProduct {

    public static List<List<Object>> cartesianProduct(List<Object> setA, List<Object> setB) {
        // Check if input sets are not empty.
        // Otherwise return null since we can't generate Cartesian Product out of them.
        if (setA == null || setB == null || setA.isEmpty() || setB.isEmpty()) {
            return null;
        }

        // Init product set.
        List<List<Object>> product = new ArrayList<>();

        // Now, let's go through all elements of a first and second set and form all possible pairs.
        for (Object elementA : setA) {
            for (Object elementB : setB) {
                // Add current product pair to the product set.
                List<Object> currentPair = new ArrayList<>();
                currentPair.add(elementA);
                currentPair.add(elementB);
                product.add(currentPair);
            }
        }

        // Return cartesian product set.
        return product;
    }

}
