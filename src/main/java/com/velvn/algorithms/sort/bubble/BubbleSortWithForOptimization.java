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
        int length = array.length - 1;
        int unsortedLength;
        for (int i = 0; i < length; i++) {
            unsortedLength = length - i + 1;
            for (int j = 1; j < unsortedLength; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    @Override
    public String info() {
        return "Bubble sort with for optimization.";
    }
}
