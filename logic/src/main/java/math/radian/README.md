《程序员数学：弧度》—— 弧度与角的相互转换

作者：小傅哥
<br/>博客：[https://bugstack.cn](https://bugstack.cn)

> 沉淀、分享、成长，让自己和他人都能有所收获！😄

## 一、前言

**弧度**，用符号rad表示，是国际单位制(SI)的角度单位，是许多数学领域中使用的角度测量的标准单位。该单位以前是国际单位制的补充单位（在该类别于 1995 年废除之前）。弧度在 SI 中被定义为无量纲单位，1 rad = 1。[2]因此它的符号经常被省略，尤其是在数学写作中。

## 二、定义

弧度定义为从圆心截取长度等于圆半径的弧的夹角。更一般地，对角的弧度大小等于弧长与圆半径之比；那是 θ = s / r，其中 θ 是以弧度表示的对角，s 是弧长，r 是半径。一个直角就是 π/2 的弧度。

一整圈对应的旋转角度（360°）是圆周的长度除以半径，即 2πr / r  = 2π。因此 2π 弧度等于 360度。

关于 2π rad = 360° 可是使用弧长的公式导出，larc = 2πr(θ/360°) 由于弧度的长度等于园半径的所对的角度的量度 1 = 2π(1 rad/360°) 这可以进一步简化为 1 = 2π rad / 360° 两边乘以 360° = 2 π rad

## 三、实现

<div align="center">
    <img src="https://bugstack.cn/images/article/algorithm/logic/radian-01.gif?raw=true" width="350px">
</div>

```java
public double degreeToRadian(double degree) {
    return degree * (Math.PI / 180);
}

public double radianToDegree(double radian){
    return radian * (180 / Math.PI);
}
```

| 弧度 | 角度  |
| ---- | ----- |
| 0    | 0°    |
| π/12 | 15°   |
| π/6  | 30°   |
| π/4  | 45°   |
| 1个  | 57.3° |
| π/3  | 60°   |
| π/2  | 90°   |
| π    | 180°  |
| 2π   | 360°  |

---

- [https://en.wikipedia.org/wiki/Radian](https://en.wikipedia.org/wiki/Radian)
