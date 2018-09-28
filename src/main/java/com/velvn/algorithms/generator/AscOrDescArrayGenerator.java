package com.velvn.algorithms.generator;

import com.velvn.algorithms.Array;

public class AscOrDescArrayGenerator extends ArrayGenerator{

    private final boolean asc;

    public AscOrDescArrayGenerator(int length, boolean asc) {
        super(length);
        this.asc = asc;
    }

    @Override
    public Array generate() {
        int[] array = new int[getLength()];
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
        return (asc ? "ASC" : "DESC") + ". Array length = " + getLength();
    }
}
