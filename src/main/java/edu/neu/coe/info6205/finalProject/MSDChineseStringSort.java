package edu.neu.coe.info6205.finalProject;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

/**
 * Class to implement Most significant digit string sort (a radix sort).
 */
public class MSDChineseStringSort {

    /**
     * Sort an array of Strings using MSDStringSort.
     *
     * @param a the array to be sorted.
     */
    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[n];
        auxCollationKeys = new CollationKey[n];
        collationKeys = new CollationKey[n];
        for (int i = 0; i < n; i++) {
            collationKeys[i] = collator.getCollationKey(a[i]);
        }
        sort(a, 0, n, 0);
    }

    /**
     * Sort from a[lo] to a[hi] (exclusive), ignoring the first d characters of each String.
     * This method is recursive.
     *
     * @param a the array to be sorted.
     * @param lo the low index.
     * @param hi the high index (one above the highest actually processed).
     * @param d the number of characters in each String to be skipped.
     */
    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi < lo + cutoff) InsertionSortMSD.sort(collationKeys, a, lo, hi, d);
        else {
            int[] count = new int[radix + 2];        // Compute frequency counts.
            for (int i = lo; i < hi; i++)
                count[charAt(collationKeys[i], d) + 2]++;
            for (int r = 0; r < radix + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = lo; i < hi; i++) {
                // Distribute
                aux[count[charAt(collationKeys[i], d) + 1]] = a[i];
                auxCollationKeys[count[charAt(collationKeys[i], d) + 1]++] = collationKeys[i];
            }
            // Copy back.
            if (hi - lo >= 0) {
                System.arraycopy(aux, 0, a, lo, hi - lo);
                System.arraycopy(auxCollationKeys, 0, collationKeys, lo, hi - lo);
            }
            // Recursively sort for each character value.
            // TO BE IMPLEMENTED
            for (int r = 0; r < radix; r++) {
                sort(a, count[r] + lo, count[r + 1] + lo, d + 1);
            }
        }
    }

    private static int charAt(CollationKey k, int d) {
        byte[] array = k.toByteArray();
        if (d < array.length) return Byte.toUnsignedInt(array[d]);
        else return -1;
    }

    private static final int radix = 256;
    private static final int cutoff = 15;
    private static final Collator collator = Collator.getInstance(Locale.CHINA);
    private static CollationKey[] collationKeys;
    private static CollationKey[] auxCollationKeys;
    private static String[] aux;       // auxiliary array for distribution
}