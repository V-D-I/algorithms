package com.vdi.algorithms.search;

import java.util.Arrays;

public class BinarySearch<T extends Comparable<T>> extends Search<T> {

    public BinarySearch(T[] orderedArray) {
        super(orderedArray);
    }

    @Override
    public int search(T element) {
        int foundedElementIndex = -1;
        int startIndex = 0;
        int lastIndex = array.length - 1;
        while (startIndex <= lastIndex) {
            int midpoint = (lastIndex + startIndex) / 2;
            int compareResult = element.compareTo(array[midpoint]);

            if (compareResult == 0) {
                foundedElementIndex = midpoint;
                break;
            } else if (compareResult < 0) {
                lastIndex = midpoint - 1;
            } else {
                startIndex = midpoint + 1;
            }
        }

        return foundedElementIndex;
    }
}
