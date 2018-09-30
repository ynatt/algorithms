package com.velvn.algorithms.sort.quick;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;
import java.util.Random;

public class QuickSort extends SortAlgorithm {

    private Random random = new Random();

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
            int same = countSame(middle);
            sort(start, middle - same);
            sort(middle + 1, end);
        }
    }

    private int countSame(int index) {
        int pivot = array[index];
        int i = 1;
        while ((index - i) != -1 && array[index - i] == pivot) {
            i++;
        }
        return --i;
    }

    private int randomPartition(int start, int end) {
        int i = start + random.nextInt(end - start + 1);
        swap(end, i);
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
        return "Quick sort.";
    }
}
