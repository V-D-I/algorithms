package com.vdi.algorithms.sort;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] unsortedArray) {
        T prev;
        T current;
        for (int i = 1; i <= unsortedArray.length - 1; i++) {
            current = unsortedArray[i];
            prev = unsortedArray[i - 1];

            if (current.compareTo(prev) < 0) {
                for (int j = i; j > 0; --j) {
                    if (unsortedArray[j].compareTo(unsortedArray[j - 1]) > 0)
                        break;
                    else {
                        T cache = unsortedArray[j];
                        unsortedArray[j] = unsortedArray[j - 1];
                        unsortedArray[j - 1] = cache;
                    }
                }
            }
        }
    }
}
