package com.vdi.algorithms.sort;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    public BubbleSort(T[] array) {
        super(array);
    }

    @Override
    public T[] sort() {
        T current;
        T next;
        boolean hasSwap;
        for (int i = 1; i < array.length; i++) {
            hasSwap = false;
            for (int j = 0; j < array.length - i; j++) {
                current = array[j];
                next = array[j + 1];

                if (current.compareTo(next) > 0) {
                    array[j] = next;
                    array[j+1] = current;
                    hasSwap = true;
                }
            }
            if (!hasSwap)
                return array;
        }

        return array;
    }
}
