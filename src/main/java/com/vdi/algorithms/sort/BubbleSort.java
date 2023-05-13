package com.vdi.algorithms.sort;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] unsortedArray) {
        T current;
        T next;
        boolean hasSwap;
        for (int i = 1; i < unsortedArray.length; i++) {
            hasSwap = false;
            for (int j = 0; j < unsortedArray.length - i; j++) {
                current = unsortedArray[j];
                next = unsortedArray[j + 1];

                if (current.compareTo(next) > 0) {
                    unsortedArray[j] = next;
                    unsortedArray[j + 1] = current;
                    hasSwap = true;
                }
            }
            if (!hasSwap)
                return;
        }
    }
}
