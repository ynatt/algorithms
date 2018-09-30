package com.velvn.algorithms.sort.merge;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

public class MergeSort extends SortAlgorithm {


    public MergeSort(ArrayGenerator generator) {
        super(generator);
    }

    public MergeSort(int[] array) {
        super(array);
    }

    @Override
    public void execute() {
        mergeSort(array,0,array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end){
        if(start<end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private void merge(int[] array, int start, int middle, int end){
        if(start == end){
            return;
        }
        int leftArraySize = middle - start + 1;
        int rightArraySize = end - middle;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];
        System.arraycopy(array, start, leftArray, 0, leftArraySize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightArraySize);
        int i = 0;
        int j = 0;
        for(int k = start ; k <= end; k++){
            if(i == leftArraySize) {
                System.arraycopy(rightArray,j,array,k,rightArraySize - j);
                return;
            }
            if(j == rightArraySize){
                System.arraycopy(leftArray,i,array,k,leftArraySize - i);
                return;
            }
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    @Override
    public String info() {
        return "Merge sort.";
    }
}
