package com.vdi.algorithms.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] unsortedArray) {
        mergeSort(unsortedArray, 1, unsortedArray.length);
    }

    private void mergeSort(T[] array, int start, int end) {
        if (end > start) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private void merge(T[] array, int start, int middle, int end) {
        start--;
        T[] left = Arrays.copyOfRange(array, start, middle);
        T[] right = Arrays.copyOfRange(array, middle, end);

        int li = 0, ri = 0;
        for (int i = start; i < end; i++) {

            if (ri >= right.length) {
                array[i] = left[li];
                li++;
                continue;
            }
            if (li >= left.length) {
                array[i] = right[ri];
                ri++;
                continue;
            }

            if (left[li].compareTo(right[ri]) <= 0) {
                array[i] = left[li];
                li++;
            } else {
                array[i] = right[ri];
                ri++;
            }
        }
    }
}
