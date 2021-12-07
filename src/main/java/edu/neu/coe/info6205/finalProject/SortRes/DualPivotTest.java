package edu.neu.coe.info6205.finalProject.SortRes;

import edu.neu.coe.info6205.finalProject.BenchMark.Shuffle;
import edu.neu.coe.info6205.finalProject.ChineseQuickSort_DualPivot;
import edu.neu.coe.info6205.finalProject.ChineseWords;
import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DualPivotTest {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        List<String> location = new ArrayList<>();
        Configuration(list, location);
        for(int i = 0;i < list.size();i++){
            sort(list.get(i), location.get(i));
        }
    }

    public static void sort(String name,String location) throws IOException {
        Config config = Config.load(DualPivotTest.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, name)
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        String[] sort = new ChineseQuickSort_DualPivot(xHelper).sort(strings);
        FileRead.writing(sort, location);
    }

    public static void Configuration(List<String> list,List<String> location){
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/100");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/SortRes/DualPivotRes");

    }



}
