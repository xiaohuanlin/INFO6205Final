package edu.neu.coe.info6205.finalProject.BenchMark;

import edu.neu.coe.info6205.finalProject.ChineseQuickSort_DualPivot;
import edu.neu.coe.info6205.finalProject.ChineseTimSort;
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

public class ChineseTimSort_BM {
    public static void main(String[] args) throws IOException {
        ChineseTimSort_BM chineseTimSort_bm = new ChineseTimSort_BM();
        chineseTimSort_bm.sort250();
        chineseTimSort_bm.sort500();
        chineseTimSort_bm.sort1000();
        chineseTimSort_bm.sort2000();
        chineseTimSort_bm.sort4000();
    }
    public void sort250() throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/250")
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseTimSort(xHelper).sort(strings), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort500() throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/500")
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseTimSort(xHelper).sort(strings), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort1000() throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/1000")
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseTimSort(xHelper).sort(strings), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort2000() throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/2000")
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseTimSort(xHelper).sort(strings), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }

    public void sort4000() throws IOException {
        Config config = Config.load(DualPivot_BM.class);
        List<String> list = new ArrayList<>();
        String[] strings = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/data/4000")
                .toArray(new String[0]);
        Helper<ChineseWords> xHelper = HelperFactory.create("", strings.length, config);
        xHelper.init(strings.length);
        Supplier<String[]> supplier = () -> strings;
        Benchmark_Timer<String[]> sort = new Benchmark_Timer<String[]>("sort", Shuffle::shuffle, t -> new ChineseTimSort(xHelper).sort(strings), null);
        double v = sort.runFromSupplier(supplier, 10);
        System.out.println(v);
    }
}
