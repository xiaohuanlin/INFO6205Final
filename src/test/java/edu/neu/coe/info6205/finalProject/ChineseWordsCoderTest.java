package edu.neu.coe.info6205.finalProject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChineseWordsCoderTest {

    @Test
    public void testHuskyEncodeLess() {
        ChineseWordsCoder coder = new ChineseWordsCoder();
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("张");

        assertTrue(coder.huskyEncode(left) < coder.huskyEncode(right));
    }

    @Test
    public void testHuskyEncodeEqual() {
        ChineseWordsCoder coder = new ChineseWordsCoder();
        ChineseWords left = new ChineseWords("肖");
        ChineseWords right = new ChineseWords("肖");

        assertEquals(coder.huskyEncode(left), coder.huskyEncode(right));
    }

    @Test
    public void testHuskyEncodeLessWithMoreWords() {
        ChineseWordsCoder coder = new ChineseWordsCoder();
        ChineseWords left = new ChineseWords("张飞");
        ChineseWords right = new ChineseWords("张良");

        assertTrue(coder.huskyEncode(left) < coder.huskyEncode(right));
    }
}