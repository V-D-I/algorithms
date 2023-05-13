package com.vdi.algorithms.sort;

public abstract class Sort<T extends Comparable<T>> {
    protected T[] array;


    public Sort(T[] array) {
        this.array = array;
    }


    public abstract T[] sort();
}
