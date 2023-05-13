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

    @BeforeAll
    static void init() {
        initIntegerSearchers();
        initStringSearchers();
        initCustomObjectSearchers();
    }

    private static void initIntegerSearchers() {
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>(new Integer[]{1, 2, 3, 4, 5});
        integerSearchAlgorithms.add(integerLinearSearch);
    }
    private static void initStringSearchers() {
        LinearSearch<String> stringLinearSearch = new LinearSearch<>(new String[]{
                "apple", "banana", "orange", "kiwifruit", "coconut"
        });
        stringSearchAlgorithms.add(stringLinearSearch);
    }
    private static void initCustomObjectSearchers() {
        LinearSearch<Fruit> objectLinearSearch = new LinearSearch<>(new Fruit[]{
                new Fruit("apple"), new Fruit("banana"), new Fruit("orange"), new Fruit("kiwifruit"), new Fruit("coconut")
        });
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
    void search_shouldReturnCorrectString() {
        String elementToFind = "orange";
        for (Search<String> searchAlgorithm : stringSearchAlgorithms) {
            String foundedElement = searchAlgorithm.get(elementToFind);
            assertEquals(elementToFind, foundedElement);
        }
    }

    @Test
    void search_shouldReturnCorrectObject() {
        Fruit elementToFind = new Fruit("orange");
        for (Search<Fruit> searchAlgorithm : objectSearchAlgorithms) {
            Fruit foundedElement = searchAlgorithm.get(elementToFind);
            assertEquals(elementToFind, foundedElement);
        }
    }

    @Test
    void search_shouldReturnCorrectInteger() {
        Integer elementToFind = 3;
        for (Search<Integer> searchAlgorithm : integerSearchAlgorithms) {
            Integer foundedElement = searchAlgorithm.get(elementToFind);
            assertEquals(elementToFind, foundedElement);
        }
    }


}