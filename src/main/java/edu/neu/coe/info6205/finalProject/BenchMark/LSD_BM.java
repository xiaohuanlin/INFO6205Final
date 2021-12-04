package edu.neu.coe.info6205.finalProject.BenchMark;

import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.LSDChineseStringSort;
import edu.neu.coe.info6205.finalProject.MSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LSD_BM {
    public static void main(String[] args) {
        LSD_BM lsd_bm = new LSD_BM();
        lsd_bm.sort250();
        lsd_bm.sort500();
        lsd_bm.sort1000();
        lsd_bm.sort2000();
        lsd_bm.sort4000();
    }
    public void sort250(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/250")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new LSDChineseStringSort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
    public void sort500(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/500")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new LSDChineseStringSort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort1000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/1000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new LSDChineseStringSort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort2000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/2000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new LSDChineseStringSort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort4000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/4000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new LSDChineseStringSort().sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
}
