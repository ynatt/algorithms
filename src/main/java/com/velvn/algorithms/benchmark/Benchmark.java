package com.velvn.algorithms.benchmark;

import com.velvn.algorithms.Algorithm;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Benchmark {

    private final List<Algorithm> algorithms;

    public Benchmark(Algorithm... algorithms) {
        this.algorithms = new ArrayList<>(Arrays.asList(algorithms));
    }

    public void benchmark(){
        for (Algorithm algorithm : algorithms) {
            System.out.print(algorithm.info());
            LocalTime start = LocalTime.now();
            algorithm.execute();
            LocalTime end = LocalTime.now();
            System.out.println(" Execution time = " + Duration.between(start,end).toMillis() / 1000d + " seconds");
        }
    }

    public void addAlgorithm(Algorithm algorithm){
        algorithms.add(algorithm);
    }

    public void addAlgorithms(Algorithm... algorithms){
        this.algorithms.addAll(Arrays.asList(algorithms));
    }
}
