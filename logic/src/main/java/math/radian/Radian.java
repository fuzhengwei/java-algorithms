package math.radian;

/**
 * @author 小傅哥，微信：fustack
 * @description 弧度（符号rad）是测量角度的单位，是许多数学领域中使用的标准角度测量单位。
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Radian {

    public double degreeToRadian(double degree) {
        return degree * (Math.PI / 180);
    }

    public double radianToDegree(double radian){
        return radian * (180 / Math.PI);
    }

}
