package sets.combinations.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import sets.combinations.Combinations;
import sets.permutations.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class CombinationsTest {

    @Test
    public void test_combineWithRepetitions() {
        List<String> comboOptions = new ArrayList<>();
        comboOptions.add("1");
        comboOptions.add("2");
        comboOptions.add("3");
        List<List<String>> lists = Combinations.combineWithRepetitions(comboOptions, 2);
        for (List<String> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }

    @Test
    public void test_combineWithoutRepetitions() {
        String[] comboOptions = {"1", "2", "3"};
        List<List<String>> lists = Combinations.combineWithoutRepetitions(comboOptions, 2);
        for (List<String> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }

}
