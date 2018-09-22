package com.velvn.algorithms.generator;

import com.velvn.algorithms.generator.Generator;

import java.util.ArrayList;

public class ArrayGenerator implements Generator<ArrayList<Integer>,Integer> {
    @Override
    public ArrayList<Integer> generate(Integer length) {
        ArrayList<Integer> array = new ArrayList<>(length);
        for(int i = 0; i < length; i++){
            array.add(length - i);
        }
        return array;
    }
}
