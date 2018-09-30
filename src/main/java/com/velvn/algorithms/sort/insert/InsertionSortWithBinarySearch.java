package com.velvn.algorithms.sort.insert;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

public class InsertionSortWithBinarySearch extends SortAlgorithm {


    public InsertionSortWithBinarySearch(ArrayGenerator generator) {
        super(generator);
    }

    public InsertionSortWithBinarySearch(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        int key;
        int j;
        for(int i = 1, len = array.length; i < len; i++){
            key = array[i];
            j = binarySearch(array, 0, i - 1, key);
            shift(array, j, i - j, 1, true);
            array[j] = key;
        }
    }

    private int binarySearch(int[] array, int start, int end, int key){
        if(start == end) {
            if (array[start] <= key) {
                return start + 1;
            } else {
                return start;
            }
        }
        int middle = (start + end) / 2;
        if(array[middle] == key){
            return middle + 1;
        }
        if(array[middle] < key){
            return binarySearch(array, middle + 1, end, key);
        } else {
            return binarySearch(array, start, middle, key);
        }
    }

    private void shift(int[] array, int pos, int length, int offset, boolean toRight){
        System.arraycopy(array, pos, array, pos + (toRight ? offset : -offset), length);
    }

    @Override
    public String info() {
        return "Insertion sort with binary search.";
    }
}
