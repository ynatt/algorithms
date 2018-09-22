package com.velvn.algorithms;

import com.velvn.algorithms.benchmark.Benchmark;
import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.generator.Generator;
import com.velvn.algorithms.sort.bubble.BubbleSortWithOptimization;
import com.velvn.algorithms.sort.bubble.BubbleSortWithPrimitiveArrayAndWithOptimization;
import com.velvn.algorithms.sort.bubble.BubbleSortWithPrimitiveArrayAndWithoutOptimization;
import com.velvn.algorithms.sort.bubble.BubbleSortWithoutOptimization;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Generator<ArrayList<Integer>, Integer> generator = new ArrayGenerator();

        System.out.print("Enter array length = ");
        String arrayLength = new Scanner(System.in).nextLine();

        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        arrays.add(generator.generate(Integer.valueOf(arrayLength)));
        arrays.add(generator.generate(Integer.valueOf(arrayLength)));

        int[][] primitiveArrays = {makePrimitiveArray(generator.generate(Integer.valueOf(arrayLength))),
                makePrimitiveArray(generator.generate(Integer.valueOf(arrayLength)))};
        checkArraysIsSorted(primitiveArrays);
        checkArraysIsSorted(arrays);

        Algorithm bubbleSortWithoutOptimization = new BubbleSortWithoutOptimization(arrays.get(0));
        Algorithm bubbleSortWithOptimization = new BubbleSortWithOptimization(arrays.get(1));
        Algorithm bubbleSortWithPrimitiveArrayAndWithoutOptimization = new BubbleSortWithPrimitiveArrayAndWithoutOptimization(primitiveArrays[0]);
        Algorithm bubbleSortWithPrimitiveArrayAndWithOptimization = new BubbleSortWithPrimitiveArrayAndWithOptimization(primitiveArrays[1]);


        Benchmark benchmark = new Benchmark(bubbleSortWithoutOptimization,
                bubbleSortWithOptimization,
                bubbleSortWithPrimitiveArrayAndWithoutOptimization,
                bubbleSortWithPrimitiveArrayAndWithOptimization);
        benchmark.benchmark();

        checkArraysIsSorted(primitiveArrays);
        checkArraysIsSorted(arrays);
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
