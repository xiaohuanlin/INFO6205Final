package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;

public class ChineseHuskySort {

    public String[] sort(String[] s) {
        ChineseWords[] chineseWords = new ChineseWords[s.length];
        for (int i = 0; i < s.length; i++) {
            chineseWords[i] = new ChineseWords(s[i]);
        }

        PureHuskySort<ChineseWords> sorter = new PureHuskySort<>(new ChineseWordsCoder(), true, false);
        sorter.sort(chineseWords);

        for (int i = 0; i < s.length; i++) {
            s[i] = chineseWords[i].getOrigin();
        }
        return s;
    }
}

