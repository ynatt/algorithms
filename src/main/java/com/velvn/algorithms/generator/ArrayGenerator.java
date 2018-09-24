package com.velvn.algorithms.generator;

import com.velvn.algorithms.Array;

public class ArrayGenerator implements DataGenerator {

    private final int length;

    private final boolean asc;

    public ArrayGenerator(int length, boolean asc) {
        this.length = length;
        this.asc = asc;
    }

    @Override
    public Array generate() {
        int[] array = new int[length];
        if (asc) {
            for (int i = 0, len = array.length; i < len; i++) {
                array[i] = i + 1;
            }
        } else {
            for (int i = 0, len = array.length; i < len; i++) {
                array[i] = len - i;
            }
        }
        return new Array(array);
    }

    @Override
    public String info() {
        return (asc ? "ASC" : "DESC") + ". Array length = " + length;
    }
}
