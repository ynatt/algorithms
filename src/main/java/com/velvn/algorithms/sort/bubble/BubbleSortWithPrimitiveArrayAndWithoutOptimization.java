package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.Algorithm;

public class BubbleSortWithPrimitiveArrayAndWithoutOptimization implements Algorithm{

    final int[] array;

    public BubbleSortWithPrimitiveArrayAndWithoutOptimization(int[] array) {
        this.array = array;
    }

    @Override
    public void execute() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    void swap(int f, int s) {
        int temp = array[f];
        array[f] = array[s];
        array[s]= temp;
    }

    @Override
    public String info() {
        return "Bubble sort with primitive array and without optimizations. Array length = " + array.length;
    }
}
