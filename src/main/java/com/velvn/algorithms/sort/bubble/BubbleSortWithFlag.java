package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.generator.ArrayGenerator;

public class BubbleSortWithFlag extends BubbleSortWithForOptimization {

    public BubbleSortWithFlag(ArrayGenerator generator) {
        super(generator);
    }

    public BubbleSortWithFlag(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        boolean sorted;
        int length = array.length - 1;
        int unsortedLength;
        for (int i = 0; i < length; i++) {
            sorted = true;
            unsortedLength = length - i + 1;
            for (int j = 1; j < unsortedLength; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }

    @Override
    public String info() {
        return super.info() + " With flag.";
    }
}
