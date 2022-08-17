package com.tarun.general;

public class Backtracking {

    public static void main(String[] args) {
        System.out.println(placeNQueen(new int[5][5], 5));

        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        System.out.println(solveSudoku(grid, grid.length));
    }


    //N-Queen Problems for backtracking

    static boolean placeNQueen(int[][] board, int N) {
        if (N > board.length) {
            return false;
        }
        return nQueen(board, 0);
    }

    static boolean nQueen(int[][] board, int row) {

        if (row == board.length) {
            return true;
        }

        for (int col = 0; col < board[0].length; col++) {

            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (nQueen(board, row + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i <= board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }


    // sudoku problem

    private static boolean solveSudoku(int[][] grid, int n) {

        boolean isEmpty = true;
        int row = -1;
        int col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                }
            }

            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty){
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafeToPlace(grid, row, col, num)) {
                grid[row][col] = num;
                if (solveSudoku(grid, n)) {
                    return true;
                } else
                    grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafeToPlace(int[][] grid, int row, int col, int num) {

        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return false;
            }
            if (grid[i][col] == num) {
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }

        }
        return true;
    }
}

