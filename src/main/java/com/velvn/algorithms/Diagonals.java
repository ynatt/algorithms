package com.velvn.algorithms;

import java.util.Arrays;

public class Diagonals {

    public static double[] getDiagonal(SquareMatrix matrix, int diagonalNumber){
        int dimension = matrix.getDimension();
        if(diagonalNumber > 2 * matrix.getDimension() - 1 || diagonalNumber <= 0){
            throw new IllegalArgumentException();
        }
        int i_0;
        int j_0;
        int count;
        if(diagonalNumber < dimension){
            i_0 = diagonalNumber - 1;
            j_0 = 0;
            count = diagonalNumber;
        } else {
            i_0 = dimension - 1;
            j_0 = diagonalNumber - dimension;
            count = dimension - j_0;
        }
        double[] diagonal = new double[count];
        int i = i_0;
        int j = j_0;
        for(int k = 0; k < count; k++){
            System.out.println(i +" "+ j);
            diagonal[k] = matrix.get(i, j);
            i--;
            j++;
        }
        return diagonal;
    }

    public static void main(String[] args) {
        double[][] elements = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        SquareMatrix matrix = new SquareMatrix(elements);
        System.out.println(Arrays.toString(Diagonals.getDiagonal(matrix, 4)));
    }
}
