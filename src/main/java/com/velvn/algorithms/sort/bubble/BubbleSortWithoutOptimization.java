package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.Algorithm;

import java.util.ArrayList;

public class BubbleSortWithoutOptimization implements Algorithm {

    final ArrayList<Integer> array;

    public BubbleSortWithoutOptimization(ArrayList<Integer> array) {
        this.array = array;
    }

    @Override
    public void execute() {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size() - i; j++) {
                if (array.get(j - 1).compareTo(array.get(j)) > 0) {
                    swap(j - 1, j);
                }
            }
        }
    }

    void swap(int f, int s) {
        int temp = array.get(f);
        array.set(f, array.get(s));
        array.set(s, temp);
    }

    @Override
    public String info() {
        return "Bubble sort without optimizations. Array length = " + array.size();
    }
}
