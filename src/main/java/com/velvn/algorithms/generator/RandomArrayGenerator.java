package com.velvn.algorithms.generator;

import com.velvn.algorithms.Array;

import java.util.Random;

public class RandomArrayGenerator extends ArrayGenerator {

    private Random random = new Random();

    private final int maxNumber;

    public RandomArrayGenerator(int length, int maxNumber) {
        super(length);
        this.maxNumber = maxNumber;
    }

    @Override
    public Array generate() {
        int[] array = new int[getLength()];
        for (int i = 0; i < array.length; i++) {
            array[i] = next();
        }
        return new Array(array);
    }

    private int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public String info() {
        return String.format("Randomized with max number = %s. Array length = %s", maxNumber, getLength());
    }
}
