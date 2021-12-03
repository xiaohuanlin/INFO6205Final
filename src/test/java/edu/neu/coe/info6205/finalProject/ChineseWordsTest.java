package edu.neu.coe.info6205.finalProject;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChineseWordsTest {

    @Test
    public void testConstructorForInteger() {
        ChineseWords chineseWords = new ChineseWords(1);

        assertEquals("1", chineseWords.getOrigin());
    }

    @Test
    public void testConstructorForDouble() {
        ChineseWords chineseWords = new ChineseWords(1.1);

        assertEquals("1.1", chineseWords.getOrigin());
    }

    @Test
    public void testConstructorForString() {
        ChineseWords chineseWords = new ChineseWords("x");

        assertEquals("x", chineseWords.getOrigin());
    }

    @Test
    public void testConstructorForChinese() {
        ChineseWords chineseWords = new ChineseWords("肖");

        assertEquals("肖", chineseWords.getOrigin());
    }

    @Test
    public void testCompareToLessThanZero() {
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("张");

        assertTrue(left.compareTo(right) < 0);
    }

    @Test
    public void testCompareToBiggerThanZero() {
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("林");

        assertTrue(left.compareTo(right) > 0);
    }

    @Test
    public void testCompareToEqualZero() {
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("肖");

        assertEquals(0, left.compareTo(right));
    }

    @Test
    public void testCompareToStartAtExceedLength() {
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("肖");

        assertEquals(0, left.compareToStartAt(right, Integer.MAX_VALUE));
    }

    @Test
    public void testCompareToStartAtLessThanZeroFromSecondByte() {
        int d = 1;

        ChineseWords left = new ChineseWords("王");
        System.out.println(left.getBytesArray()[d]);

        ChineseWords right = new ChineseWords("太");
        System.out.println(right.getBytesArray()[d]);

        assertTrue(left.compareToStartAt(right, d) > 0);
    }
}