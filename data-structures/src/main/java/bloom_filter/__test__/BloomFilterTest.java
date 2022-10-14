package bloom_filter.__test__;

import bloom_filter.BloomFilter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.BitSet;
import java.util.Random;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class BloomFilterTest {

    private Logger logger = LoggerFactory.getLogger(BloomFilterTest.class);

    @Test
    public void test() {
        String val00 = "小傅哥";
        String val01 = "https://bugstack.cn";
        String val02 = "https://github.com/fuzhengwei/CodeGuide";
        String val03 = "https://github.com/fuzhengwei";

        BloomFilter filter = new BloomFilter(Integer.MAX_VALUE, new int[]{7, 19, 43, 77});
        filter.add(val00);
        filter.add(val01);
        filter.add(val02);

        logger.info("测试结果 val00：{} 布隆过滤器：{}", val00, filter.contains(val00));
        logger.info("测试结果 val01：{} 布隆过滤器：{}", val01, filter.contains(val01));
        logger.info("测试结果 val02：{} 布隆过滤器：{}", val02, filter.contains(val02));
        logger.info("测试结果 val02：{} 布隆过滤器：{}", val03, filter.contains(val03));
    }

    @Test
    public void test_BitSet() {
        BitSet bits = new BitSet(8);
        bits.set("谢飞机".hashCode() & (8 - 1), true);
//        bits.set("金毛狮王".hashCode() & (8 - 1), true);
//        bits.set("杨左使".hashCode() & (8 - 1), true);

        boolean exist = bits.get("成昆".hashCode() & (8 - 1));
        logger.info("测试结果：{}", exist);

        System.out.println("金毛狮王".hashCode() & (8 - 1));
        System.out.println("杨左使".hashCode() & (8 - 1));
        System.out.println("拎瓢冲".hashCode() & (8 - 1));
        System.out.println("谢飞机".hashCode() & (8 - 1));
        System.out.println("成昆".hashCode() & (8 - 1));

        System.out.println(Integer.toBinaryString(6));
    }

    @Test
    public void test_random() {
        BloomFilter filter = new BloomFilter(Integer.MAX_VALUE, new int[]{7, 19, 43, 77});
        for (int i = 0; i < 8000; i++) {
            StringBuilder code = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                code.append(new Random().nextInt(9));
            }
            if (filter.contains(code.toString())) {
                System.out.println("碰撞：" + code);
                continue;
            }
            filter.add(code.toString());
        }
    }

}
