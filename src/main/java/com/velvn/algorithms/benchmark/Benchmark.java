package com.velvn.algorithms.benchmark;

import com.velvn.algorithms.Algorithm;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Benchmark {

    private final List<Algorithm> algorithms;

    public Benchmark(Algorithm... algorithms) {
        this.algorithms = Arrays.asList(algorithms);
    }

    public void benchmark(){
        for (Algorithm algorithm : algorithms) {
            System.out.println(algorithm.info());
            LocalTime start = LocalTime.now();
            algorithm.execute();
            LocalTime end = LocalTime.now();
            System.out.println("Execution time = " + Duration.between(start,end).toMillis() / 1000d + " seconds");
        }
    }
}
