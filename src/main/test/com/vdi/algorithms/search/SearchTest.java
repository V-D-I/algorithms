package com.vdi.algorithms.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class SearchTest {

    static List<Search<Integer>> integerSearchAlgorithms = new ArrayList<>();
    static List<Search<String>> stringSearchAlgorithms = new ArrayList<>();
    static List<Search<Fruit>> objectSearchAlgorithms = new ArrayList<>();
    private static Integer[] testIntegers;
    private static String[] testStrings;
    private static Fruit[] testCustomObjects;

    @BeforeAll
    static void init() {
        initIntegerSearchers();
        initStringSearchers();
        initCustomObjectSearchers();
    }

    private static void initIntegerSearchers() {
        testIntegers = new Integer[]{1, 120, 260, 340, 550, 731, 1231};
        Search<Integer> integerLinearSearch = new LinearSearch<>(testIntegers);
        Search<Integer> integerBinarySearch = new BinarySearch<>(testIntegers);
        integerSearchAlgorithms.add(integerLinearSearch);
        integerSearchAlgorithms.add(integerBinarySearch);
    }

    private static void initStringSearchers() {
        testStrings = new String[]{
                "apple", "banana", "orange", "kiwifruit", "coconut"
        };
        Search<String> stringLinearSearch = new LinearSearch<>(testStrings);
        stringSearchAlgorithms.add(stringLinearSearch);
    }

    private static void initCustomObjectSearchers() {
        testCustomObjects = new Fruit[]{
                new Fruit("apple"), new Fruit("banana"), new Fruit("orange"), new Fruit("kiwifruit"), new Fruit("coconut")
        };
        Search<Fruit> objectLinearSearch = new LinearSearch<>(testCustomObjects);
        objectSearchAlgorithms.add(objectLinearSearch);
    }

    static class Fruit {
        private final String name;

        public Fruit(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fruit fruit = (Fruit) o;
            return name.equals(fruit.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    @Test
    void search_shouldReturnCorrectInteger() {
        for (Integer integerToFind : testIntegers) {
            for (Search<Integer> searchAlgorithm : integerSearchAlgorithms) {
                Integer foundedElement = searchAlgorithm.get(integerToFind);
                assertEquals(integerToFind, foundedElement, searchAlgorithm.toString().concat(", doesn't return correct element"));
            }
        }
    }

    @Test
    void search_shouldReturnCorrectString() {
        for (String stringToFind : testStrings) {
            for (Search<String> searchAlgorithm : stringSearchAlgorithms) {
                String foundedElement = searchAlgorithm.get(stringToFind);
                assertEquals(stringToFind, foundedElement);
            }
        }
    }

    @Test
    void search_shouldReturnCorrectObject() {
        for (Fruit objectToFind : testCustomObjects) {
            for (Search<Fruit> searchAlgorithm : objectSearchAlgorithms) {
                Fruit foundedElement = searchAlgorithm.get(objectToFind);
                assertEquals(objectToFind, foundedElement);
            }
        }
    }


}