package edu.neu.coe.info6205.finalProject.BenchMark;


import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.MSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ChineseQuickSort_DualPivot_BM {
    private Config config;
    public ChineseQuickSort_DualPivot_BM(Config config) {
        this.config = config;
    }

    public static void main(String[] args) throws IOException {
        Config config = Config.load(ChineseQuickSort_DualPivot_BM.class);
        ChineseQuickSort_DualPivot_BM bm = new ChineseQuickSort_DualPivot_BM(Config.load(ChineseQuickSort_DualPivot_BM.class));
        bm.sort250();
        bm.sort500();
        bm.sort1000();
        bm.sort2000();
        bm.sort4000();
    }
    public void sort250(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/250")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> MSDChineseStringSort.sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
    public void sort500(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/500")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> MSDChineseStringSort.sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort1000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/shuffledChinese.txt")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> MSDChineseStringSort.sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort2000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/2000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> MSDChineseStringSort.sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort4000(){
        List<String> list = new ArrayList<>();
        Supplier<String[]> supplier = () ->
                FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/4000")
                        .toArray(new String[0]);
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> MSDChineseStringSort.sort(t), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
}

