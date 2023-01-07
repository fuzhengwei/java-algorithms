package math.liu_hui.__test__;

import math.liu_hui.LiuHui;
import org.junit.jupiter.api.Test;

public class LiuHuiTest {

    @Test
    public void test_LiuHui() {
        System.out.println("计算圆周率[复杂度低]：" + LiuHui.liuHui02(25));
        System.out.println("计算圆周率[复杂度高]：" + LiuHui.liuHui01(10000));
    }

}
