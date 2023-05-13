package com.vdi.algorithms.search;

public abstract class Search<T> {
    protected T[] array;

    public Search(T[] array) {
        this.array = array;
    }

    public boolean contain(T element) {
        return !(search(element) < 0);
    }

    public T get(T element) {
        int i = search(element);
        if (i < 0)
            return null;

        return array[i];
    }

    public abstract int search(T element);

}
