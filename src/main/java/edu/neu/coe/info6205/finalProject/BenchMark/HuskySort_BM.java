package edu.neu.coe.info6205.finalProject.BenchMark;

import edu.neu.coe.info6205.finalProject.ChineseHuskySort;
import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.LSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class HuskySort_BM {
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
        Supplier<String[]> supplier = () -> strings;

        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        String[] sort1 = new ChineseHuskySort().sort(strings);
        FileRead.writing(sort1, location);
        System.out.println(v);
    }

    public static void Configuration(List<String> list,List<String> location){
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/250");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/500");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/1000");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/2000");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/4000");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/Husky_Res/250.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/Husky_Res/500.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/Husky_Res/1000.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/Husky_Res/2000.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/Husky_Res/4000.txt");
    }



}
