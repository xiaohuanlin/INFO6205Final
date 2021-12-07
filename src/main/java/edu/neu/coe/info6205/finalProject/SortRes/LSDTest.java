package edu.neu.coe.info6205.finalProject.SortRes;

import edu.neu.coe.info6205.finalProject.BenchMark.Shuffle;
import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.LSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LSDTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> location = new ArrayList<>();
        Configuration(list, location);
        for(int i = 0;i < list.size();i++){
            sort(list.get(i), location.get(i));
        }
    }
    public static void sort(String name,String location){
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, name)
                .toArray(new String[0]);
        String[] sort = new LSDChineseStringSort().sort(strings);
        FileRead.writing(sort, location);

    }

    public static void Configuration(List<String> list,List<String> location){
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/100");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/SortRes/LSDRes");
    }
}
