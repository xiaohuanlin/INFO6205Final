package edu.neu.coe.info6205.finalProject;

import java.text.CollationKey;

/**
 * This is a basic implementation of insertion sort.
 * It does not extend Sort, nor does it employ any optimizations.
 */
public class InsertionSortMSD {

    public static void sort(CollationKey[] a, String[] ori, int lo, int hi, int d) {
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                swap(a, j, j - 1);
                swap(ori, j, j - 1);
            }
    }

    private static boolean less(CollationKey v, CollationKey w, int d) {
        byte[] vArray = v.toByteArray();
        byte[] wArray = w.toByteArray();
        int vLength = vArray.length;
        int wLength = wArray.length;
        int length = Math.min(vLength, wLength);
        for (int i = d; i < length; i++) {
            int unsignV = Byte.toUnsignedInt(vArray[i]);
            int unsignW = Byte.toUnsignedInt(wArray[i]);
            if (unsignV < unsignW) {
                return true;
            } else if (unsignV > unsignW) {
                return false;
            }
        }
        return vLength < wLength;
    }

    private static void swap(Object[] a, int j, int i) {
        Object temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
