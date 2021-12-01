package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;

public class ChineseQuickSort_DualPivot {
    private final Helper<ChineseWords> helper;

    public ChineseQuickSort_DualPivot(Helper<ChineseWords> helper) {
        this.helper = helper;
    }

    public String[] sort(String[] s) {
        ChineseWords[] chineseWords = new ChineseWords[s.length];
        for (int i = 0; i < s.length; i++) {
            chineseWords[i] = new ChineseWords(s[i]);
        }

        final Sort<ChineseWords> sorter = new QuickSort_DualPivot<>(helper);
        ChineseWords[] result = sorter.sort(chineseWords);

        for (int i = 0; i < s.length; i++) {
            s[i] = result[i].getOrigin();
        }
        return s;
    }
}

