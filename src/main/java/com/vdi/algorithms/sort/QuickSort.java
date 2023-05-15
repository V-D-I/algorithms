package com.vdi.algorithms.sort;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] unsortedArray) {
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    public void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int keyIndex = partition(array, left, right);
            quickSort(array, left, keyIndex - 1);
            quickSort(array, keyIndex + 1, right);
        }
    }

    private int partition(T[] array, int left, int right) {
        T key = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(key) <= 0) {
                i++;
                T cache = array[i];
                array[i] = array[j];
                array[j] = cache;
            }
        }
        T cache = array[i + 1];
        array[i + 1] = array[right];
        array[right] = cache;
        return (i + 1);
    }
}
