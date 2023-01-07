package math.liu_hui;

import java.util.Random;

/**
 * @author 小傅哥，微信：fustack
 * @description 刘辉的π算法 隔圆术 https://en.wikipedia.org/wiki/Liu_Hui%27s_%CF%80_algorithm
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class LiuHui {

    public static double liuHui01(int splitPoint) {
        // 圆的半径
        double r = 1.0;
        // 正方形的边长
        double s = 2.0 * r;

        Random rand = new Random();
        // 计算圆内随机生成的点的个数
        int m = 0;
        for (int i = 0; i < splitPoint; i++) {
            double x = rand.nextDouble() * s - r;
            double y = rand.nextDouble() * s - r;
            if (x * x + y * y <= r * r) {
                m++;
            }
        }

        // 面积比 = 圆的面积 / 正方形的面积
        double p = (double) m / splitPoint;
        // 圆周率 = 面积比 * 4
        return p * 4;
    }

    // 圆的半径
    static final double circleRadius = 1;

    static double getNGonSideLength(double sideLength, int splitCounter) {
        if (splitCounter <= 0) {
            return sideLength;
        }

        double halfSide = sideLength / 2;

        // 使用勾股定理（勾股定理）
        double perpendicular = Math.sqrt(Math.pow(circleRadius, 2) - Math.pow(halfSide, 2));
        double excessRadius = circleRadius - perpendicular;
        double splitSideLength = Math.sqrt(Math.pow(excessRadius, 2) + Math.pow(halfSide, 2));

        return getNGonSideLength(splitSideLength, splitCounter - 1);
    }

    static int getNGonSideCount(int splitCount) {
        // 内接六边形 (6-gon) 开始
        int hexagonSidesCount = 6;

        // 在每次拆分迭代中，我们制作 N 边形：6 边形、12 边形、24 边形、48 边形等等。
        return hexagonSidesCount * (splitCount > 0 ? (int) Math.pow(2, splitCount) : 1);
    }

    public static double liuHui02(int splitCount) {
        double nGonSideLength = getNGonSideLength(circleRadius, splitCount - 1);
        int nGonSideCount = getNGonSideCount(splitCount - 1);
        double nGonPerimeter = nGonSideLength * nGonSideCount;
        double approximateCircleArea = (nGonPerimeter / 2) * circleRadius;

        return approximateCircleArea / Math.pow(circleRadius, 2);
    }

}
