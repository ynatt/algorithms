package com.velvn.algorithms.sort.quick;

import com.velvn.algorithms.generator.ArrayGenerator;
import com.velvn.algorithms.sort.SortAlgorithm;

import java.util.Arrays;

public class JavaQuickSort extends SortAlgorithm{


    public JavaQuickSort(ArrayGenerator generator) {
        super(generator);
    }

    @Override
    public void execute() {
        Arrays.sort(array);
    }

    @Override
    public String info() {
        return "Quick sort from java libs.";
    }
}
