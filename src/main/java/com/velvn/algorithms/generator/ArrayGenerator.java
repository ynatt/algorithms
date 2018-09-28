package com.velvn.algorithms.generator;

import com.velvn.algorithms.Array;

public class ArrayGenerator implements DataGenerator {

    private final int length;

    public ArrayGenerator(int length) {
        this.length = length;
    }

    @Override
    public Array generate() {
        return new Array(new int[length]);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String info() {
        return "Blank array. Array length = " + length;
    }
}
