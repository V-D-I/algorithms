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
    static Integer[] unsortedIntegersArray = sortedIntegersArray.clone();
    static List<Sort<Integer>> integerSortAlgorithms = new ArrayList<>();

    @BeforeAll
    static void init() {
        shuffle(unsortedIntegersArray);
        Sort<Integer> bubbleSort = new BubbleSort<>(unsortedIntegersArray);

        integerSortAlgorithms.add(bubbleSort);
    }


//    @BeforeEach
//    void reshuffleArrays() {
//        shuffle(integersArray);
//    }

    static <T extends Comparable<T>> void shuffle(T[] array) {
        Random random = new Random();
        int min = 0;
        int max = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(max - min + 1) + min;
            int randomPosition = random.nextInt(max - min + 1) + min;

            T temp = array[randomIndex];
            array[randomIndex] = array[randomPosition];
            array[randomPosition] = temp;
        }
    }

    @Test
    void sort() {
        for (Sort<Integer> sortAlgorithm : integerSortAlgorithms) {
            Integer[] sortedArray = sortAlgorithm.sort();
            Assertions.assertArrayEquals(sortedIntegersArray, sortedArray);
        }
    }
}