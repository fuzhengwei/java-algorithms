package sets.fisher_yates.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import sets.fisher_yates.FisherYates;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class FisherYatesTest {

    @Test
    public void test_shuffle() {
        ArrayList<String> keyList = new ArrayList<>();
        keyList.add("1");
        keyList.add("2");
        keyList.add("3");
        keyList.add("4");
        keyList.add("5");
        keyList.add("6");
        Collections.shuffle(keyList);
        System.out.println(JSON.toJSONString(keyList));
    }

    @Test
    public void test_FisherYates() {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = FisherYates.fisherYates(originalArray);
        System.out.println("测试结果：" + JSON.toJSONString(ints));
    }

}
