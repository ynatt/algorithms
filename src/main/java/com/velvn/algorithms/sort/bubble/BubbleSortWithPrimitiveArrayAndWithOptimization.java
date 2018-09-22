package com.velvn.algorithms.sort.bubble;

public class BubbleSortWithPrimitiveArrayAndWithOptimization extends BubbleSortWithPrimitiveArrayAndWithoutOptimization{
    public BubbleSortWithPrimitiveArrayAndWithOptimization(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        for (int i = 0, length = array.length; i < length; i++) {
            for (int j = 1, unsortedLength = length - i; j < unsortedLength; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    @Override
    public String info() {
        return "Bubble sort with primitive array and with optimizations. Array length = " + array.length;
    }
}
