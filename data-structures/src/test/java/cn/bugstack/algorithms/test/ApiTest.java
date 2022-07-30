package cn.bugstack.algorithms.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ApiTest {

    @Test
    public void test_linked_list() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("x");
    }

    @Test
    public void test_array_list() {
        List<String> list = new ArrayList<>();
        list.add("");

        list.get(1);
    }

    @Test
    public void test_array() {
        String[][] x = new String[2][2];
        x[0][0] = "kdkkdll";
        x[0][1] = "dd";
        x[1][0] = "pppp";
        x[1][1] = "你好";

        System.out.println(Integer.toHexString(x[0][0].hashCode()));
        System.out.println(Integer.toHexString(x[0][1].hashCode()));
        System.out.println(Integer.toHexString(x[1][0].hashCode()));
        System.out.println(Integer.toHexString(x[1][1].hashCode()));
    }

    @Test
    public void test_system_arraycopy() {
        int[] i = new int[3];
        i[0] = 0;
        i[1] = 1;
        i[2] = 2;

        int[] j = new int[3];

        System.arraycopy(i, 0, j, 0, 3);

        System.out.println(Arrays.toString(j));
    }

}
