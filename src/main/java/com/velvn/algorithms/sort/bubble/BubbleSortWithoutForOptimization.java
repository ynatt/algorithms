package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

public class BubbleSortWithoutForOptimization extends SortAlgorithm {

    public BubbleSortWithoutForOptimization(ArrayGenerator generator) {
        super(generator);
    }

    public BubbleSortWithoutForOptimization(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    @Override
    public String info() {
        return "Bubble sort without for optimization. " + dataInfo;
    }
}
