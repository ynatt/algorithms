package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.generator.ArrayGenerator;

public class BubbleSortWithForOptimization extends BubbleSortWithoutForOptimization {

    public BubbleSortWithForOptimization(ArrayGenerator generator) {
        super(generator);
    }

    public BubbleSortWithForOptimization(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        for (int i = 0, length = array.length - 1; i < length; i++) {
            for (int j = 1, unsortedLength = length - i + 1; j < unsortedLength; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    @Override
    public String info() {
        return "Bubble sort with for optimization. " + dataInfo;
    }
}
