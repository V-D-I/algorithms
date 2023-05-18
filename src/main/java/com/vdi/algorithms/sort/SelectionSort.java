package com.vdi.algorithms.sort;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] unsortedArray) {
        int indexOfMinimalElement;
        T cache;
        T min;
        for (int i = 0; i < unsortedArray.length; i++) {
            indexOfMinimalElement = i;
            min = unsortedArray[i];

            for (int j = unsortedArray.length - 1; j >= i; j--) {
                int compareResult = unsortedArray[j].compareTo(min);

                if (compareResult < 0) {
                    min = unsortedArray[j];
                    indexOfMinimalElement = j;
                }
            }

            cache = unsortedArray[i];
            unsortedArray[i] = unsortedArray[indexOfMinimalElement];
            unsortedArray[indexOfMinimalElement] = cache;
        }
    }
}
