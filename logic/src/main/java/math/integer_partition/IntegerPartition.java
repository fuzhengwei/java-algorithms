package math.integer_partition;

public class IntegerPartition {

    public static int integerPartition(int number) {
        // 创建矩阵
        int[][] partitionMatrix = new int[number + 1][number + 1];

        // 填充数据，需要将数字 1，2，3，...，n 与数字 0 组合的方法数。
        for (int numberIndex = 1; numberIndex <= number; numberIndex++) {
            partitionMatrix[0][numberIndex] = 0;
        }

        // 从 0，0 和 1，0 和 1 和 2，0 和 1 和 2 和 3 等数字中形成数字 0 的方法数。显然，我们只能使用数字 0 本身形成数字 0 的一种方法。
        for (int summandIndex = 0; summandIndex <= number; summandIndex++) {
            partitionMatrix[summandIndex][0] = 1;
        }

        // 通过动态规划方法来探究我们如何从 0，1，...，m 的加数中形成数字 m 的其他可能的选项。
        for (int summandIndex = 1; summandIndex <= number; summandIndex++) {
            for (int numberIndex = 1; numberIndex <= number; numberIndex++) {
                if (summandIndex > numberIndex) {
                    // 如果加数大于当前数字本身，那么它就不会增加任何新的数字形成方法。因此，我们可以直接从上面的行中复制数字。
                    partitionMatrix[summandIndex][numberIndex] = partitionMatrix[summandIndex - 1][numberIndex];
                } else {
                    /*
                     * 组合数等于不使用当前加数形成相同数字的组合数加上使用当前加数形成当前数字减去当前加数的数字的组合数。
                     * 例如，使用 {0, 1, 2} 的加数形成 5 的方法数等于使用 {0, 1} 的加数形成 5 的方法数（排除了加数 2）加上使用 {0, 1, 2} 的加数形成 3 的方法数（包括加数 2）的和。
                     */
                    int combosWithoutSummand = partitionMatrix[summandIndex - 1][numberIndex];
                    int combosWithSummand = partitionMatrix[summandIndex][numberIndex - summandIndex];

                    partitionMatrix[summandIndex][numberIndex] = combosWithoutSummand + combosWithSummand;
                }
            }
        }

        return partitionMatrix[number][number];
    }


}