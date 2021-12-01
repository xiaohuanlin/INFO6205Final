package edu.neu.coe.info6205.finalProject;

/**
 * This is a basic implementation of insertion sort.
 * It does not extend Sort, nor does it employ any optimizations.
 */
public class InsertionSortMSDForCompareAt {

    public static <T extends ComparableStartAt<T>> void sort(T[] a, int lo, int hi, int d) {
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                swap(a, j, j - 1);
            }
    }

    private static <T extends ComparableStartAt<T>> boolean less(T v, T w, int d) {
        return v.compareToStartAt(w, d) < 0;
    }

    private static void swap(Object[] a, int j, int i) {
        Object temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
