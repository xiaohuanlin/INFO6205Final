package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.Sort;
import edu.neu.coe.info6205.sort.linearithmic.TimSort;

public class ChineseTimSort {
    private final Helper<ChineseWords> helper;

    public ChineseTimSort(Helper<ChineseWords> helper) {
        this.helper = helper;
    }

    public String[] sort(String[] s) {
        ChineseWords[] chineseWords = new ChineseWords[s.length];
        for (int i = 0; i < s.length; i++) {
            chineseWords[i] = new ChineseWords(s[i]);
        }

        final Sort<ChineseWords> sorter = new TimSort<>(helper);
        ChineseWords[] result = sorter.sort(chineseWords);

        for (int i = 0; i < s.length; i++) {
            s[i] = result[i].getOrigin();
        }
        return s;
    }
}

