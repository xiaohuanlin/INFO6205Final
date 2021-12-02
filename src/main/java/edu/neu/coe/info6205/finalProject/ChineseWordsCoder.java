package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoder;

public class ChineseWordsCoder implements HuskyCoder<ChineseWords> {
    @Override
    public String name() {
        return "ChineseCoder";
    }

    @Override
    public long huskyEncode(ChineseWords chineseWords) {
        long res = 0;
        byte[] arr = chineseWords.getBytesArray();
        int length = 8;
        for (int i = 0; i < length; i++) {
            res <<= 8;
            res |= (arr[i] & 255);
        }
        return res;
    }

    @Override
    public boolean perfect() {
        return true;
    }
}
