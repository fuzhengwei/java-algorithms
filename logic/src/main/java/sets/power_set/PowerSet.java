package sets.power_set;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 幂集
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PowerSet {

    public static List<List<Integer>> btPowerSet(int[] originalSet) {
        return btPowerSetRecursive(originalSet, new ArrayList<>(), new ArrayList<>(), 0);
    }

    /**
     * 这段代码是使用递归的方法求一个数组的所有子集（即幂集）。
     * - originalSet是要求幂集的数组
     * - allSubsets是存储所有子集的结果集合
     * - currentSubSet是正在生成的当前子集
     * - startAt是从originalSet的哪个位置开始生成子集
     * 它通过递归不断地在当前子集上添加元素，最终生成所有子集，并将其存储在allSubsets中。
     */
    private static List<List<Integer>> btPowerSetRecursive(int[] originalSet, List<List<Integer>> allSubsets, List<Integer> currentSubSet, int startAt) {
        for (int position = startAt; position < originalSet.length; position++) {
            currentSubSet.add(originalSet[position]);
            allSubsets.add(new ArrayList<>(currentSubSet));
            btPowerSetRecursive(originalSet, allSubsets, currentSubSet, position + 1);
            currentSubSet.remove(currentSubSet.size() - 1);
        }
        return allSubsets;
    }

    /**
     * 这段代码是一个用递归算法实现的求集合的幂集的Java函数。它将一个给定的整数数组作为输入，并返回所有子集的列表。
     * 该函数以一个空的列表开始，每次遍历输入数组的元素并将该元素添加到现有的所有子集中，最终返回所有子集的列表。
     */
    public static List<List<Integer>> caPowerSet(int[] originalSet) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());

        for (int i : originalSet) {
            int existingSetsNum = sets.size();
            for (int setIdx = 0; setIdx < existingSetsNum; setIdx++) {
                List<Integer> set = new ArrayList<>(sets.get(setIdx));
                set.add(i);
                sets.add(set);
            }
        }

        return sets;
    }

    /**
     * 这段代码是使用位运算求一个数组的所有子集（即幂集）。
     * originalSet是要求幂集的数组
     * 它通过位运算不断地将组合索引和元素索引进行比较，最终生成所有子集，并将其存储在subSets中。
     */
    public static List<List<Integer>> bwPowerSet(int[] originalSet) {
        List<List<Integer>> subSets = new ArrayList<>();

        int numberOfCombinations = (int) Math.pow(2, originalSet.length);

        for (int combinationIndex = 0; combinationIndex < numberOfCombinations; combinationIndex++) {
            List<Integer> subSet = new ArrayList<>();

            for (int setElementIndex = 0; setElementIndex < originalSet.length; setElementIndex++) {
                if ((combinationIndex & (1 << setElementIndex)) != 0) {
                    subSet.add(originalSet[setElementIndex]);
                }
            }

            subSets.add(subSet);
        }

        return subSets;
    }

}
