package edu.neu.coe.info6205.finalProject;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MSDChineseStringSortTest {

    @Test
    public void sortNormalLessArray() {
        String[] input = {"张三", "李四", "王五"};
        MSDChineseStringSort.sort(input);
        System.out.println(Arrays.toString(input));

        String[] expected = {"李四", "王五", "张三"};
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortNormalMoreArray() {
        String[] input = {
                "张三", "李四", "王五", "赵九", "太史慈",
                "诸葛亮", "赵云", "关羽", "刘备", "张飞",
                "司马懿", "曹操", "周瑜", "黄盖", "张良",
                "淳于琼", "丰成秀吉"
        };
        MSDChineseStringSort.sort(input);
        System.out.println(Arrays.toString(input));

        String[] expected = {
                "曹操", "淳于琼", "丰成秀吉", "关羽", "黄盖",
                "李四", "刘备", "司马懿", "太史慈", "王五",
                "张飞", "张良", "张三", "赵九", "赵云", "周瑜",
                "诸葛亮"
        };
        assertArrayEquals(expected, input);
    }
}