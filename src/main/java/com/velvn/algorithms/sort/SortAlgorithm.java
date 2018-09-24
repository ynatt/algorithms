package com.velvn.algorithms.sort;

import com.velvn.algorithms.Algorithm;
import com.velvn.algorithms.generator.ArrayGenerator;

public abstract class SortAlgorithm implements Algorithm {

    protected final String dataInfo;

    protected final int[] array;

    public SortAlgorithm(ArrayGenerator generator) {
        this.array = generator.generate().getArray();
        dataInfo = generator.info();
    }

    public SortAlgorithm(int[] array){
        this.array = array;
        dataInfo = "Array length = " + array.length;
    }

    protected void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
