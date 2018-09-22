package com.velvn.algorithms.generator;

public interface Generator<O,I> {
    O generate(I input);
}
