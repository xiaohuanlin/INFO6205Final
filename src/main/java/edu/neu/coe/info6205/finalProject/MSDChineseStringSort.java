package edu.neu.coe.info6205.finalProject;



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
        auxPinyin = new String[n];
        pinyin = new String[n];
       
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < a[i].length(); j++) {
                sb.append(PinyinHelper.toHanyuPinyinStringArray(a[i].charAt(j))[0]);
            }
            pinyin[i] = sb.toString();
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
     * @param d the number of alphabets in each Pinyin to be skipped.
     */
    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi < lo + cutoff) InsertionSortMSD.sort(pinyin, a, lo, hi, d);
        else {
            int[] count = new int[radix + 2];        // Compute frequency counts.
            for (int i = lo; i < hi; i++)
                count[charAt(pinyin[i], d) + 2]++;
            for (int r = 0; r < radix + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = lo; i < hi; i++) {
                aux[count[charAt(pinyin[i], d) + 1]] = a[i];
                auxPinyin[count[charAt(pinyin[i], d) + 1]++] = pinyin[i];
            }
            // Copy back.
            if (hi - lo >= 0) {
                System.arraycopy(aux, 0, a, lo, hi - lo);
                System.arraycopy(auxPinyin, 0, pinyin, lo, hi - lo);
            }
            // Recursively sort for each character value.
            // TO BE IMPLEMENTED
            for (int r = 0; r < radix; r++) {
                sort(a, count[r] + lo, count[r + 1] + lo - 1, d + 1);
            }
        }
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    private static final int radix = 256;
    private static final int cutoff = 15;
    private static String[] aux;       // auxiliary array for distribution
    private static String[] auxPinyin;
    private static String[] pinyin;
}