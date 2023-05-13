package com.vdi.algorithms.sort;

public interface Sort<T extends Comparable<T>> {
    void sort(T[] unsortedArray);
}
