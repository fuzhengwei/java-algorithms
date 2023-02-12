package sets.power_set.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import sets.power_set.PowerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PowerSetTest {

    @Test
    public void btPowerSetTest() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));

        System.out.println(JSON.toJSONString(expected));
        System.out.println(PowerSet.btPowerSet(new int[]{1}));

        expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(3));

        System.out.println(JSON.toJSONString(expected));
        System.out.println(PowerSet.btPowerSet(new int[]{1, 2, 3}));
    }

}
