package com.velvn.algorithms.sort;

import com.velvn.algorithms.Algorithm;

import java.util.Arrays;

public class MergeArrays implements Algorithm {

    private int[] leftArray;

    private int[] rightArray;

    private int[] result;

    public MergeArrays(int[] firstArray, int[] secondArray) {
        this.leftArray = firstArray;
        this.rightArray = secondArray;
        result = new int[firstArray.length + secondArray.length];
    }

    @Override
    public void execute() {
        int i = 0;
        int j = 0;
        for(int k = 0; k < leftArray.length + rightArray.length; k++){
            if(i == leftArray.length){
                System.arraycopy(rightArray,j,result,k,rightArray.length - j);
                return;
            }
            if(j == rightArray.length){
                System.arraycopy(leftArray,i,result,k,leftArray.length - i);
                return;
            }
            if(leftArray[i] <= rightArray[j]){
                result[k] = leftArray[i];
                i++;
            }else {
                result[k] = rightArray[j];
                j++;
            }
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

    public int[] getResult() {
        return result;
    }

    @Override
    public String dataInfo() {
        return null;
    }

    @Override
    public String info() {
        return null;
    }

    public static void main(String[] args) {
        int[] right = {1,2,3};
        int[] left = {0,2,4,5,5};
        MergeArrays mergeArraysAlgorithm = new MergeArrays(left,right);
        mergeArraysAlgorithm.execute();
        System.out.println(Arrays.toString(mergeArraysAlgorithm.getResult()));
    }
}
