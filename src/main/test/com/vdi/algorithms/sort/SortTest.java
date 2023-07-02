package com.vdi.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(JUnit4.class)
class SortTest {

    static Integer[] sortedIntegersArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static List<Sort<Integer>> integerSortAlgorithms = new ArrayList<>();

    @BeforeAll
    static void init() {
        Sort<Integer> bubbleSort = new BubbleSort<>();
        Sort<Integer> insertionSort = new InsertionSort<>();
        Sort<Integer> quickSort = new QuickSort<>();
        Sort<Integer> selectionSort = new SelectionSort<>();
        Sort<Integer> mergeSort = new MergeSort<>();

        integerSortAlgorithms.add(bubbleSort);
        integerSortAlgorithms.add(insertionSort);
        integerSortAlgorithms.add(quickSort);
        integerSortAlgorithms.add(selectionSort);
        integerSortAlgorithms.add(mergeSort);
    }

    static <T extends Comparable<T>> T[] shuffle(T[] array) {
        Random random = new Random();
        T[] unsortedArray = array.clone();
        int min = 0;
        int max = unsortedArray.length - 1;
        for (int i = 0; i < unsortedArray.length; i++) {
            int randomIndex = random.nextInt(max - min + 1) + min;
            int randomPosition = random.nextInt(max - min + 1) + min;

            T temp = unsortedArray[randomIndex];
            unsortedArray[randomIndex] = unsortedArray[randomPosition];
            unsortedArray[randomPosition] = temp;
        }

        return unsortedArray;
    }

    @Test
    void sort() {
        for (Sort<Integer> sortAlgorithm : integerSortAlgorithms) {
            Integer[] unsortedArray = shuffle(sortedIntegersArray);
            sortAlgorithm.sort(unsortedArray);
            Assertions.assertArrayEquals(sortedIntegersArray, unsortedArray);
        }
    }
}