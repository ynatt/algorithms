package com.velvn.algorithms.benchmark;

import java.time.Duration;
import java.time.LocalTime;

public class ExecutionTimer {

    private LocalTime start;

    private LocalTime end;

    public void start(){
        start = LocalTime.now();
    }

    public void end() {
        end = LocalTime.now();
    }

    public double seconds(){
        return Duration.between(start,end).toNanos() / 1_000_000_000d;
    }
}
