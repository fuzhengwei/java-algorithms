package sets.permutations.__test__;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import sets.permutations.Permutations;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PermutationsTest {

    @Test
    public void test_permutationWithRepetitions() {
        int[] permutationOptions = {1, 2, 3};
        List<List<Integer>> permutation = Permutations.permutationWithRepetitions(permutationOptions, 2);
        for (List<Integer> list : permutation) {
            System.out.println(JSON.toJSONString(list));
        }
    }

    @Test
    public void test_permutationWithoutRepetitions() {
        int[] permutationOptions = {1, 2, 3};
        List<List<Integer>> permutation = Permutations.permutationWithoutRepetitions(permutationOptions);
        for (List<Integer> list : permutation) {
            System.out.println(JSON.toJSONString(list));
        }
    }

}
