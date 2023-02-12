package sets.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 组合 (有/无重复)
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Combinations {

    /**
     * 此代码是一个 Java 函数，它从允许重复的元素列表中生成给定长度的所有可能组合。
     * <p>
     * 该函数有两个输入：
     * <p>
     * 1. `comboOptions`：生成组合的元素列表。
     * 2. `comboLength`：要生成的每个组合的长度。
     * <p>
     * 该函数返回一个字符串列表列表，其中每个内部列表代表一个组合。
     * <p>
     * 该函数的逻辑如下：
     * <p>
     * 1. 如果`comboLength`等于 1，则`comboOptions`列表中的每个元素本身就是一个组合并添加到`combos`列表中。
     * 2. 如果`comboLength`大于 1，则该函数使用相同的函数生成更小尺寸的组合。对于列表中的每个元素，该函数通过使用当前选项之后的剩余选项调用自身来`comboOptions`生成元素组合。`comboLength - 1`
     * 3. 最后，该函数将当前选项与每个较小的组合连接起来，并将结果添加到`combos`列表中。
     * <p>
     * 请注意，生成的组合中允许重复。
     */
    public static List<List<String>> combineWithRepetitions(List<String> comboOptions, int comboLength) {
        // If the length of the combination is 1 then each element of the original array
        // is a combination itself.
        if (comboLength == 1) {
            List<List<String>> combos = new ArrayList<>();
            for (String comboOption : comboOptions) {
                List<String> combo = new ArrayList<>();
                combo.add(comboOption);
                combos.add(combo);
            }
            return combos;
        }

        // Init combinations array.
        List<List<String>> combos = new ArrayList<>();

        // Remember characters one by one and concatenate them to combinations of smaller lengths.
        // We don't extract elements here because the repetitions are allowed.
        for (int optionIndex = 0; optionIndex < comboOptions.size(); optionIndex++) {
            // Generate combinations of smaller size.
            String currentOption = comboOptions.get(optionIndex);
            List<String> remainingOptions = new ArrayList<>(comboOptions.subList(optionIndex, comboOptions.size()));
            List<List<String>> smallerCombos = combineWithRepetitions(remainingOptions, comboLength - 1);

            // Concatenate currentOption with all combinations of smaller size.
            for (List<String> smallerCombo : smallerCombos) {
                List<String> combo = new ArrayList<>();
                combo.add(currentOption);
                combo.addAll(smallerCombo);
                combos.add(combo);
            }
        }

        return combos;
    }

    /**
     * 这段代码是一个递归函数，它的目的是生成不含重复元素的长度为 "comboLength" 的元素组合，这些元素来自 "comboOptions" 数组，并返回这些组合的列表。
     *
     * @param comboOptions
     * @param comboLength
     * @return
     */
    public static List<List<String>> combineWithoutRepetitions(String[] comboOptions, int comboLength) {
        List<List<String>> combos = new ArrayList<>();

        if (comboLength == 1) {
            for (String comboOption : comboOptions) {
                List<String> singleOption = new ArrayList<>();
                singleOption.add(comboOption);
                combos.add(singleOption);
            }
            return combos;
        }

        for (int i = 0; i < comboOptions.length; i++) {
            String currentOption = comboOptions[i];
            String[] smallerOptions = new String[comboOptions.length - i - 1];
            System.arraycopy(comboOptions, i + 1, smallerOptions, 0, comboOptions.length - i - 1);
            List<List<String>> smallerCombos = combineWithoutRepetitions(smallerOptions, comboLength - 1);
            for (List<String> smallerCombo : smallerCombos) {
                List<String> newCombo = new ArrayList<>();
                newCombo.add(currentOption);
                newCombo.addAll(smallerCombo);
                combos.add(newCombo);
            }
        }
        return combos;
    }

}
