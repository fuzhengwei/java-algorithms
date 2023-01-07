package math.fourier_transform;

/**
 * @author 小傅哥，微信：fustack
 * @description 傅里叶变换(FT)将时间函数（信号）分解为组成它的频率，其方式类似于将音乐和弦表示为其构成音符的频率（或音高）的方式。
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DiscreteFourierTransform {

    public Complex[] dft(Complex[] x) {
        int n = x.length;

        // exp(-2i*n*PI)=cos(-2*n*PI)+i*sin(-2*n*PI)=1
        if (n == 1)
            return x;

        Complex[] result = new Complex[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Complex(0, 0);
            for (int k = 0; k < n; k++) {
                //使用欧拉公式e^(-i*2pi*k/N) = cos(-2pi*k/N) + i*sin(-2pi*k/N)
                double p = -2 * k * Math.PI / n;
                Complex m = new Complex(Math.cos(p), Math.sin(p));
                result[i].plus(x[k].multiple(m));
            }
        }
        return result;
    }

}
