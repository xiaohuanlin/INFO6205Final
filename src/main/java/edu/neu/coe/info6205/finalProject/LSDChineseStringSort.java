package edu.neu.coe.info6205.finalProject;

public class LSDChineseStringSort {

    private final int BYTE_RANGE = 256;

    /**
     * findMaxLength method returns maximum length of all available strings in an array
     *
     * @param arr It contains an array of ChineseWord from which maximum length needs to be found
     * @return int Returns maximum length value
     */
    private int findMaxLength(ChineseWords[] arr) {
        int maxLength = arr[0].getBytesArray().length;
        for (ChineseWords w: arr)
            maxLength = Math.max(maxLength, w.getBytesArray().length);
        return maxLength;
    }

    /**
     * charByteVal method returns Byte value of particular character in a String.
     *
     * @param w Chinese input for which Byte Value need to be found
     * @param position byte position of which ASCII value needs to be found. If byte
     *                     doesn't exist then ASCII value of null i.e. 0 is returned
     * @return int Returns Byte value
     */
    private int charByteVal(ChineseWords w, int position) {
        byte[] array = w.getBytesArray();
        if (position >= array.length) {
            return 0;
        }
        return Byte.toUnsignedInt(array[position]);
    }

    /**
     * charSort method is implementation of LSD sort algorithm at particular character.
     *
     * @param arr          It contains an array of ChineseWord on which LSD char sort needs to be performed
     * @param position     This is the position on which sort would be performed
     * @param from         This is the starting index from which sorting operation will begin
     * @param to           This is the ending index up until which sorting operation will be continued
     */
    private void charSort(ChineseWords[] arr, int position, int from, int to) {
        int[] count = new int[BYTE_RANGE + 2];
        ChineseWords[] result = new ChineseWords[arr.length];

        for (int i = from; i <= to; i++) {
            int c = charByteVal(arr[i], position);
            count[c + 2]++;
        }

        // transform counts to indices
        for (int r = 1; r < BYTE_RANGE + 2; r++)
            count[r] += count[r - 1];

        // distribute
        for (int i = from; i <= to; i++) {
            int c = charByteVal(arr[i], position);
            result[count[c + 1]++] = arr[i];
        }

        // copy back
        if (to + 1 - from >= 0) System.arraycopy(result, 0, arr, from, to + 1 - from);
    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param arr    It contains an array of ChineseWord on which LSD sort needs to be performed
     * @param from   This is the starting index from which sorting operation will begin
     * @param to     This is the ending index up until which sorting operation will be continued
     */
    public void sort(ChineseWords[] arr, int from, int to) {
        int maxLength = findMaxLength(arr);
        for (int i = maxLength - 1; i >= 0; i--)
            charSort(arr, i, from, to);
    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param strArr It contains an array of String on which LSD sort needs to be performed
     */
    public String[] sort(String[] strArr) {
        ChineseWords[] chineseWords = new ChineseWords[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            chineseWords[i] = new ChineseWords(strArr[i]);
        }

        sort(chineseWords, 0, strArr.length - 1);

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = chineseWords[i].getOrigin();
        }
        return strArr;
    }
}
