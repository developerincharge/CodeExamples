package com.rizvi.immutable;

import java.util.Arrays;

public final class ImmutableMatrix {
    private final int[][] matrix;
    
    public ImmutableMatrix(int[][] matrix) {
        // Deep copy of 2D array
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }
    
    // Getter returns copy of array
    public int[][] getMatrix() {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }
    
    // Better: Return element instead of whole array
    public int getElement(int row, int col) {
        return matrix[row][col];
    }
    
    // Even better: Return unmodifiable view
    public int[] getRow(int row) {
        return Arrays.copyOf(matrix[row], matrix[row].length);
    }
}