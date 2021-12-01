package edu.neu.coe.info6205.finalProject;

import java.text.Collator;
import java.util.Locale;

/**
 * Class used for represent combination of the chinese character and its Pinyin.
 */
public class ChineseWords implements Comparable<ChineseWords>, ComparableStartAt<ChineseWords> {

    private static final Collator collator = Collator.getInstance(Locale.CHINA);
    private final String origin;
    private final byte[] bytesArray;

    public <T> ChineseWords(T w) {
        this.origin = w.toString();
        this.bytesArray = collator.getCollationKey(w.toString()).toByteArray();
    }

    @Override
    public int compareTo(ChineseWords o) {
        return compareToStartAt(o, 0);
    }

    @Override
    public int compareToStartAt(ChineseWords o, int d) {
        int vLength = bytesArray.length;
        int wLength = o.bytesArray.length;
        int length = Math.min(vLength, wLength);
        for (;d < length; d++) {
            int unsignV = Byte.toUnsignedInt(bytesArray[d]);
            int unsignW = Byte.toUnsignedInt(o.bytesArray[d]);
            if (unsignV < unsignW) {
                return -1;
            } else if (unsignV > unsignW) {
                return 1;
            }
        }
        if (vLength == wLength) {
            return 0;
        }
        return vLength < wLength ? -1: 1;
    }

    public byte[] getBytesArray() {
        return bytesArray;
    }

    public String getOrigin() {
        return origin;
    }
}
