package com.velvn.algorithms;

import com.velvn.algorithms.generator.Data;

public class Array implements Data,HasInformation {

    private final int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String info() {
        return "Array length = " + array.length;
    }
}
