package com.vdi.algorithms.search;

public class LinearSearch<T> extends Search<T> {

    public LinearSearch(T[] array) {
        super(array);
    }

    @Override
    public int search(T element) {
        int indexOfFoundedElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                indexOfFoundedElement = i;
                break;
            }
        }
        return indexOfFoundedElement;
    }
}
