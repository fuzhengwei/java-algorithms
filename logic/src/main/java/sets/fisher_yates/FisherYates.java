package sets.fisher_yates;

import java.util.Random;

/**
 * @author 小傅哥，微信：fustack
 * @description 洗牌算法
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class FisherYates {

    public static int[] fisherYates(int[] originalArray) {
        int[] array = originalArray.clone();
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }

        return array;
    }

}
