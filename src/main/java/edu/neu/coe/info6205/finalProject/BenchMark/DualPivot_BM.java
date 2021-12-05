package edu.neu.coe.info6205.finalProject.BenchMark;

import edu.neu.coe.info6205.finalProject.*;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DualPivot_BM {
    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        List<String> location = new ArrayList<>();
        Configuration(list, location);
        for(int i = 0;i < list.size();i++){
            sort(list.get(i), location.get(i));
        }
    }

    public static void sort(String name,String location) throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, name)
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle,  t -> new ChineseQuickSort_DualPivot(xHelper).sort(strings), t->FileRead.writing(t, location));
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public static void Configuration(List<String> list,List<String> location){
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/250");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/500");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/1000");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/2000");
        list.add("src/main/java/edu/neu/coe/info6205/finalProject/data/4000");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/DualPivot_Res/250.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/DualPivot_Res/500.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/DualPivot_Res/1000.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/DualPivot_Res/2000.txt");
        location.add("src/main/java/edu/neu/coe/info6205/finalProject/DualPivot_Res/4000.txt");
    }



}
