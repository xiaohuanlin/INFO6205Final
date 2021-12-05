package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.finalProject.BenchMark.Shuffle;
import org.junit.Test;

import java.util.Arrays;

public class ShuffleTest {
    @Test
    public void shuffleRes(){
        String[] strings = {"张三", "李四", "王五", "赵九", "太史慈",
                "诸葛亮", "赵云", "关羽", "刘备", "张飞",
                "司马懿", "曹操", "周瑜", "黄盖", "张良",
                "淳于琼", "丰成秀吉"};
        String[] shuffle = Shuffle.shuffle(strings);
        System.out.println(Arrays.toString(shuffle));
    }
}
