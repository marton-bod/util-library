package com.mbod.utils;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

public class SortedList<T extends Comparable<T>> extends AbstractList<T> implements List<T> {

    private final List<T> data;

    public SortedList() {
        data = new LinkedList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
        return data.get(index);
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element to be added cannot be null");
        }
        // insert using binary search
        boolean found = false;
        int left = 0;
        int right = data.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparisonResult = data.get(mid).compareTo(element);
            if (comparisonResult == 0) {
                data.add(mid, element);
                found = true;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            data.add(left, element);
        }
        return true;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
