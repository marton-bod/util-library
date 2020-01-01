package com.mbod.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedListTest {

    @Test
    public void addingMultipleIntegers_SortsCorrectly() {
        List<Integer> sortedList = new SortedList<>();

        sortedList.addAll(List.of(45, 22, 99, 30));

        assertElementsInOrder(sortedList, 22, 30, 45, 99);
    }

    @Test
    public void addingMultipleStrings_SortsCorrectly() {
        List<String> sortedList = new SortedList<>();

        sortedList.addAll(List.of("abc", "def", "aaa", "a", "bcv", "yyy"));

        assertElementsInOrder(sortedList, "a", "aaa", "abc", "bcv", "def", "yyy");
    }

    @SafeVarargs
    private <T extends Comparable<T>>
    void assertElementsInOrder(List<T> sortedList, T... expectedElements) {
        for (int i = 0; i < expectedElements.length; ++i) {
            assertEquals(expectedElements[i], sortedList.get(i));
        }
    }

}