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
        HuskySort_BM huskySort_bm = new HuskySort_BM();
        huskySort_bm.sort250();
        huskySort_bm.sort500();
        huskySort_bm.sort1000();
        huskySort_bm.sort2000();
        huskySort_bm.sort4000();
    }
    public void sort250(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/250")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
    public void sort500(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/500")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort1000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/1000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort2000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/2000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort4000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/4000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseHuskySort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
}
