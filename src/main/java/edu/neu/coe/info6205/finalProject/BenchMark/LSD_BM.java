package edu.neu.coe.info6205.finalProject.BenchMark;

import edu.neu.coe.info6205.finalProject.FileRead;
import edu.neu.coe.info6205.finalProject.MSDChineseStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MSD_BM {
    public static void main(String[] args) {

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
}
