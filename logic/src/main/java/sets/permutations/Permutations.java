package sets.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 排列 (有/无重复)
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Permutations {

    /**
     * 这段代码是一个 Java 函数，它生成带重复元素的排列组合。它接受两个参数：
     * <p>
     * - permutationOptions：排列元素的数组。
     * - permutationLength：排列的长度，默认为 permutationOptions 的长度。
     * <p>
     * 算法使用递归的方式，如果排列的长度为 1，则将 permutationOptions 数组的每个元素作为一个列表返回；
     * 否则，首先获取不包括第一个元素的小排列，然后将第一个元素插入到每个小排列的每个可能位置上，生成所有排列组合。最后，返回排列组合的列表。
     */
    public static List<List<Integer>> permutationWithRepetitions(int[] permutationOptions, int permutationLength) {
        if (permutationLength == 1) {
            List<List<Integer>> result = new ArrayList<>();
            for (int permutationOption : permutationOptions) {
                List<Integer> item = new ArrayList<>();
                item.add(permutationOption);
                result.add(item);
            }
            return result;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        List<List<Integer>> smallerPermutations = permutationWithRepetitions(permutationOptions, permutationLength - 1);

        for (int currentOption : permutationOptions) {
            for (List<Integer> smallerPermutation : smallerPermutations) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(currentOption);
                permutation.addAll(smallerPermutation);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    /**
     * 这段 Java 代码实现了一个递归算法，它生成不带重复项的整数序列的全排列。它首先特判了如果传入的数组只有一个元素，那么返回一个只包含这个元素的 List。
     * 否则它将传入的数组分为两部分：第一个元素和剩下的元素。它先递归计算剩下的元素的全排列，然后将第一个元素插入到每个全排列的每一个可能位置。最后将所有的排列组合起来，返回结果。
     */
    public static List<List<Integer>> permutationWithoutRepetitions(int[] permutationOptions) {
        if (permutationOptions.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(List.of(permutationOptions[0]));
            return result;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        int[] smallerOptions = new int[permutationOptions.length - 1];
        System.arraycopy(permutationOptions, 1, smallerOptions, 0, smallerOptions.length);
        List<List<Integer>> smallerPermutations = permutationWithoutRepetitions(smallerOptions);

        int firstOption = permutationOptions[0];
        for (List<Integer> smallerPermutation : smallerPermutations) {
            for (int positionIndex = 0; positionIndex <= smallerPermutation.size(); positionIndex++) {
                List<Integer> permutationPrefix = new ArrayList<>(smallerPermutation.subList(0, positionIndex));
                List<Integer> permutationSuffix = new ArrayList<>(smallerPermutation.subList(positionIndex, smallerPermutation.size()));
                List<Integer> permutation = new ArrayList<>(permutationPrefix);
                permutation.add(firstOption);
                permutation.addAll(permutationSuffix);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

}
