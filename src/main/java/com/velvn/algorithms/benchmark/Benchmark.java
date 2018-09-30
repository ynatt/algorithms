package com.velvn.algorithms.benchmark;

import com.velvn.algorithms.Algorithm;
import java.util.*;

public class Benchmark {

    private final List<Algorithm> algorithms;

    private final ExecutionTimer timer;

    public Benchmark(Algorithm... algorithms) {
        this.algorithms = new ArrayList<>(Arrays.asList(algorithms));
        timer = new ExecutionTimer();
    }

    public Table benchmark(){
        Table table = new Table("Benchmark of algorithms (time in seconds)","Algorithm \\ Data");
        for (Algorithm algorithm : algorithms) {
            table.addColumnHeader(algorithm.dataInfo());
            table.addRow(algorithm.info());
            timer.start();
            algorithm.execute();
            timer.end();
            table.setCellValue(algorithm.info(), algorithm.dataInfo(), String.valueOf(timer.seconds()));
        }
        return table;
    }

    public void addAlgorithm(Algorithm algorithm){
        algorithms.add(algorithm);
    }

    public void addAlgorithms(Algorithm... algorithms){
        this.algorithms.addAll(Arrays.asList(algorithms));
    }
}
