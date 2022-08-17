package com.tarun.leetcode;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{5},{8}};

        int[][] transposeMatrix = transpose(matrix);

        for(int i = 0 ; i < transposeMatrix.length ; i++){
            for(int j =0 ; j < transposeMatrix[0].length ; j++){
                System.out.print(transposeMatrix[i][j]+",");
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transPoseMatrix = new int[m][n];

        for(int i = 0 ; i < n ;i++){
            for(int j = i ; j < m ;j++){
                transPoseMatrix[j][i] = matrix[i][j];
                if(i != j && (i < m && j < n)){
                        transPoseMatrix[i][j] = matrix[j][i];

                }
            }
        }
        return transPoseMatrix;
    }
}
