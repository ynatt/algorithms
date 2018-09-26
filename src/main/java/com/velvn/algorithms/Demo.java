package com.velvn.algorithms;

import com.velvn.algorithms.benchmark.Benchmark;
import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.bubble.BubbleSortWithFlag;
import com.velvn.algorithms.sort.bubble.BubbleSortWithForOptimization;

import com.velvn.algorithms.sort.bubble.BubbleSortWithoutForOptimization;
import com.velvn.algorithms.sort.insert.InsertionSortWithBinarySearch;
import com.velvn.algorithms.sort.insert.InsertionSortWithoutBinarySearch;
import com.velvn.algorithms.sort.merge.MergeSort;
import com.velvn.algorithms.sort.quick.QuickSort;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        System.out.print("Enter array length = ");
        String arrayLength = new Scanner(System.in).nextLine();

        ArrayGenerator generator = new ArrayGenerator(Integer.valueOf(arrayLength), false);
        Benchmark benchmark = new Benchmark(new BubbleSortWithoutForOptimization(generator),
                new BubbleSortWithForOptimization(generator),
                new BubbleSortWithFlag(generator),
                new InsertionSortWithoutBinarySearch(generator),
                new InsertionSortWithBinarySearch(generator),
                new MergeSort(generator),
                new QuickSort(generator));
        benchmark.benchmark();
    }

    private static boolean isSorted(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] makePrimitiveArray(ArrayList<Integer> arrayList) {
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    private static void checkArraysIsSorted(ArrayList<ArrayList<Integer>> arrays) {
        int index = 1;
        for (ArrayList<Integer> array : arrays) {
            if (isSorted(array)) {
                System.out.println(index + " ArrayList is sorted");
            } else {
                System.out.println(index + " ArrayList is unsorted");
            }
            index++;
        }
    }

    private static void checkArraysIsSorted(int[]... arrays) {
        int index = 1;
        for (int[] array : arrays) {
            if (isSorted(array)) {
                System.out.println(index + " Primitive array is sorted");
            } else {
                System.out.println(index + " Primitive array is unsorted");
            }
            index++;
        }
    }
}
