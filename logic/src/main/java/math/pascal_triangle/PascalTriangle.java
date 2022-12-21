package math.pascal_triangle;

import java.util.HashMap;

/**
 * @author 小傅哥，微信：fustack
 * @description 杨辉三角
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class PascalTriangle {

    public HashMap<Integer, Integer> pascalTriangle(int lineNumber) {
        HashMap<Integer, Integer> currentLine = new HashMap<>();
        currentLine.put(0, 1);

        int currentLineSize = lineNumber + 1;

        for (int numberIdx = 1; numberIdx < currentLineSize; numberIdx += 1) {
            /*
             * 第i行号中的第 -th 个条目lineNumber是 Binomial CoefficientC(lineNumber, i)并且所有行都以 value 开头1。这个思路是C(lineNumber, i)使用C(lineNumber, i-1). 它可以O(1)使用以下方法及时计算：
             * C(lineNumber, i)   = lineNumber! / ((lineNumber - i)! * i!)
             * C(lineNumber, i - 1) = lineNumber! / ((lineNumber - i + 1)! * (i - 1)!)
             *
             * 从以上两个表达式我们可以推导出下面的表达式：C(lineNumber, i) = C(lineNumber, i - 1) * (lineNumber - i + 1) / i
             * 所以C(lineNumber, i)可以从C(lineNumber, i - 1)时间上算出来O(1)
             */
            currentLine.put(numberIdx, ((null == currentLine.get(numberIdx - 1) ? 0 : currentLine.get(numberIdx - 1)) * (lineNumber - numberIdx + 1)) / numberIdx);
        }

        return currentLine;
    }

    public long combination(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private long factorial(long number) {
        if (number <= 1)
            return 1;
        else {
            return number * factorial(number - 1);
        }
    }

}
