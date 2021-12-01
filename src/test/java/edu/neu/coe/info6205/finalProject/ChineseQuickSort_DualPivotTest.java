package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.ConfigTest;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ChineseQuickSort_DualPivotTest {

    @Test
    public void sortNormalLessArray() {
        String[] input = {"张三", "李四", "王五"};
        final Config config = ConfigTest.setupConfig("true", "0", "1", "1", "");
        Helper<ChineseWords> helper = HelperFactory.create("", input.length, config);
        helper.init(input.length);

        String[] output = new ChineseQuickSort_DualPivot(helper).sort(input);
        System.out.println(Arrays.toString(output));

        String[] expected = {"李四", "王五", "张三"};
        assertArrayEquals(expected, output);
    }
}