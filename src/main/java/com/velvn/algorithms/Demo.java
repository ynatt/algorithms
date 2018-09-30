package com.velvn.algorithms;

import com.velvn.algorithms.benchmark.Benchmark;
import com.velvn.algorithms.benchmark.Table;
import com.velvn.algorithms.benchmark.TableView;
import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.generator.AscOrDescArrayGenerator;
import com.velvn.algorithms.generator.RandomArrayGenerator;
import com.velvn.algorithms.sort.bubble.BubbleSortWithFlag;
import com.velvn.algorithms.sort.bubble.BubbleSortWithForOptimization;
import com.velvn.algorithms.sort.bubble.BubbleSortWithoutForOptimization;
import com.velvn.algorithms.sort.insert.InsertionSortWithBinarySearch;
import com.velvn.algorithms.sort.insert.InsertionSortWithoutBinarySearch;
import com.velvn.algorithms.sort.merge.MergeSort;
import com.velvn.algorithms.sort.quick.JavaQuickSort;
import com.velvn.algorithms.sort.quick.QuickSort;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length = ");
        int arrayLength = scanner.nextInt();
        System.out.print("Enter max number for random array = ");
        int maxNumber = scanner.nextInt();

        ArrayGenerator descArrayGenerator = new AscOrDescArrayGenerator(arrayLength, false);
        ArrayGenerator randomArrayGenerator = new RandomArrayGenerator(arrayLength,maxNumber);
        ArrayGenerator randomArrayGeneratorMultiplied = new RandomArrayGenerator(arrayLength * 2, maxNumber);
        Benchmark benchmark = new Benchmark();

        benchmark.addAlgorithms(new BubbleSortWithoutForOptimization(descArrayGenerator),
                new BubbleSortWithoutForOptimization(randomArrayGenerator));

        benchmark.addAlgorithms(new InsertionSortWithoutBinarySearch(randomArrayGenerator),
                new InsertionSortWithBinarySearch(randomArrayGenerator));

        benchmark.addAlgorithms(new MergeSort(descArrayGenerator),
                new MergeSort(randomArrayGenerator));

        benchmark.addAlgorithms(new QuickSort(descArrayGenerator),
                new QuickSort(randomArrayGenerator),
                new QuickSort(randomArrayGeneratorMultiplied),
                new JavaQuickSort(descArrayGenerator),
                new JavaQuickSort(randomArrayGenerator),
                new JavaQuickSort(randomArrayGeneratorMultiplied));

        TableView tableView = new TableView();
        tableView.show(benchmark.benchmark());
    }
}
