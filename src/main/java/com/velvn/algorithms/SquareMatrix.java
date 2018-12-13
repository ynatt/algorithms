package com.velvn.algorithms;

import java.util.Arrays;

public class SquareMatrix {

    private double[][] elements;

    private int dimension;

    public SquareMatrix(double[][] elements) {
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            if (elements[i].length != n) {
                throw new IllegalArgumentException("Array of elements not square");
            }
        }
        dimension = n;
        this.elements = elements;
    }

    public double[] toArrayBySpiral(){
        int count = dimension;
        int i = 0;
        int j = 0;
        int k = 0;
        double[] array = new double[dimension * dimension];
        State state = State.RIGHT;
        while (count != 0){
            switch (state){
                case RIGHT:
                    for(int n = 0; n < count; array[k] = elements[j][i], n++, k++, i++);
                    i--;
                    j++;
                    state = State.DOWN;
                    count--;
                    break;
                case DOWN:
                    for(int n = 0; n < count; array[k] = elements[j][i], n++, k++, j++);
                    j--;
                    i--;
                    state = State.LEFT;
                    break;
                case LEFT:
                    for(int n = 0; n < count; array[k] = elements[j][i], n++, k++, i--);
                    i++;
                    j--;
                    state = State.UP;
                    count--;
                    break;
                case UP:
                    for(int n = 0; n < count; array[k] = elements[j][i], n++, k++, j--);
                    j++;
                    i++;
                    state = State.RIGHT;
                    break;
            }
        }
        return array;
    }

    private enum State{
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    public double[] toArrayBySnake() {
        int i = 0;
        int j = 0;
        int diagonalNum;
        double[] diagonal;
        double[] result = new double[dimension * dimension];
        int resultSize = 0;
        while (!(i == dimension - 1 && j == dimension)) {
            diagonalNum = i + j + 1;
            diagonal = formDiagonal(!(diagonalNum % 2 == 0), i, j);
            System.arraycopy(diagonal, 0, result, resultSize, diagonal.length);
            resultSize += diagonal.length;
            if (i != dimension - 1) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    private double[] formDiagonal(boolean up, int i, int j) {
        double[] diagonal;
        int i0 = i;
        int j0 = j;
        if (i == dimension - 1) {
            diagonal = new double[dimension - j];
        } else {
            diagonal = new double[i + 1];
        }
        int k = 0;
        boolean stop = false;
        do {
            if (up) {
                diagonal[k++] = elements[i][j];
                if (--i < j0 & ++j > i0) {
                    stop = true;
                }
            } else {
                diagonal[k++] = elements[j][i];
                if (++j > i0 & --i < j0) {
                    stop = true;
                }
            }
        } while (!stop);
        return diagonal;
    }

    public int getDimension() {
        return dimension;
    }

    public double get(int i, int j){
        return elements[i][j];
    }

    public static void main(String[] args) {
        double[][] elements = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        SquareMatrix matrix = new SquareMatrix(elements);
        System.out.println(Arrays.toString(matrix.toArrayBySnake()));
        System.out.println(Arrays.toString(matrix.toArrayBySpiral()));
    }
}
