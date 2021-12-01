package edu.neu.coe.info6205.finalProject;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/7/21 11:53
 **/
public class ChineseComparator implements Comparator<String> {
    Collator collator = Collator.getInstance(Locale.CHINA);

    public int compare(String s1, String s2){
        return collator.compare(s1, s2);
    }
}
