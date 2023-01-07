package math.fourier_transform.__test__;

import com.alibaba.fastjson.JSON;
import math.fourier_transform.Complex;
import math.fourier_transform.DiscreteFourierTransform;
import math.fourier_transform.FastFourierTransform;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 小傅哥，微信：fustack
 * @description 傅里叶变换测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class FourierTransformTest {

    @Test
    public void test_ApacheMath() {
        double[] inputData = null;
        int arrayLength = 4 * 1024;
        inputData = new double[arrayLength];
        for (int index = 0; index < inputData.length; index++) {
            inputData[index] = (Math.random() - 0.5) * 100.0;
        }

        FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
        org.apache.commons.math3.complex.Complex[] complexes = fft.transform(inputData, TransformType.FORWARD);
        for (int i = 0; i < 10; i++) {
            System.out.print("第" + i + "个变换前数据为：" + inputData[i] + "\t");
            System.out.println("第" + i + "个变换后数据为：" + complexes[i]);
        }
    }

    @Test
    public void test_FourierTransform() {
        System.out.println("测试结果【离散傅立叶变换】：" + Arrays.toString(new DiscreteFourierTransform().dft(
                new Complex[]{
                        new Complex(1, 3),
                })));

        System.out.println("测试结果【快速傅立叶变换】：" + Arrays.toString(new FastFourierTransform().fft(
                new Complex[]{
                        new Complex(3, 4),
                })));
    }

}
