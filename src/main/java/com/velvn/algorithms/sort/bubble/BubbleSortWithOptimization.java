package com.velvn.algorithms.sort.bubble;

import java.util.ArrayList;

public class BubbleSortWithOptimization extends BubbleSortWithoutOptimization {

    public BubbleSortWithOptimization(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void execute() {
        int length = array.size();
        int unsortedLength;
        for (int i = 0; i < length; i++) {
            unsortedLength = length - i;
            for (int j = 1; j < unsortedLength; j++) {
                if (array.get(j - 1) > array.get(j)) {
                    swap(j - 1, j);
                }
            }
        }
    }

    @Override
    public String info() {
        return "Bubble sort with optimizations. Array length = " + array.size();
    }
}
