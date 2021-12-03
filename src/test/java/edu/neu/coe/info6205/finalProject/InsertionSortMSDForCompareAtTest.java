package edu.neu.coe.info6205.finalProject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertionSortMSDForCompareAtTest {

    @Test
    public void testForChineseWords() {
        ChineseWords[] words = new ChineseWords[2];
        words[0] = new ChineseWords("肖");
        words[1] = new ChineseWords("李");

        InsertionSortMSDForCompareAt.sort(words, 0, words.length, 0);
        assertEquals("肖", words[1].getOrigin());
    }
}