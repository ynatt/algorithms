package com.velvn.algorithms.sort.quick;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

public class QuickSort extends SortAlgorithm {


    public QuickSort(ArrayGenerator generator) {
        super(generator);
    }

    public QuickSort(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        sort(0, array.length - 1);
    }

    private void sort(int start, int end) {
        if (start < end) {
            int middle = randomPartition(start, end);
            sort(start, middle - 1);
            sort(middle + 1, end);
        }
    }

    private int randomPartition(int start, int end) {
        int i = (int) Math.round(Math.random() * (end - start));
        swap(end, i + start);
        return partition(start, end);
    }

    private int partition(int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, end);
        return i + 1;
    }

    @Override
    public String info() {
        return "Quick sort. " + dataInfo;
    }
}
