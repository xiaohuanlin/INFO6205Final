package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BenchMarkTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> reading = FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/shuffledChinese.txt");

        String[] strings = reading.toArray(new String[0]);
//        MSDChineseStringSort.sort(strings);
//        FileRead.writing(strings);
        Supplier<String[]> supplier = () ->
        FileRead.reading(list, "src/main/java/edu/neu/coe/info6205/finalProject/shuffledChinese.txt")
                .toArray(new String[0]);
        Benchmark_Timer<String[]> sortChineseName = new Benchmark_Timer<>("SortChineseName", t -> MSDChineseStringSort.sort(t));
        double v = sortChineseName.runFromSupplier(supplier, 1);
        System.out.println(v);
    }
}
