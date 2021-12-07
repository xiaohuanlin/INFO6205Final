package edu.neu.coe.info6205.finalProject.SortRes;


import edu.neu.coe.info6205.finalProject.BenchMark.Shuffle;
import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.MSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MSDSortSample {
    private Config config;
    public MSDSortSample(Config config) {
        this.config = config;
    }

    public static void main(String[] args) throws IOException {
        MSDSortSample bm = new MSDSortSample(Config.load(MSDSortSample.class));
        List<String> list = new ArrayList<>();
        List<String> location = new ArrayList<>();
        Configuration(list, location);
        for(int i = 0;i < list.size();i++){
            bm.sort(list.get(i), location.get(i));
        }

    }
    public void sort(String name,String location){
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, name)
                .toArray(new String[0]);
        String[] sort = MSDChineseStringSort.sort(strings);
        FileRead.writing(sort, location);
    }

    public static void Configuration(List<String> list,List<String> location){
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/100");

        location.add("src/main/java/edu/neu/coe/info6205/finalProject/SortRes/MSDRes");


    }
}

