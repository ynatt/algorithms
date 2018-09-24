package com.velvn.algorithms.sort.insert;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

public class InsertionSortWithoutBinarySearch extends SortAlgorithm {

    public InsertionSortWithoutBinarySearch(ArrayGenerator generator) {
        super(generator);
    }

    public InsertionSortWithoutBinarySearch(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        int key;
        int j;
        for (int i = 1, len = array.length; i < len; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String info() {
        return "Insertion sort without binary search. " + dataInfo;
    }
}
