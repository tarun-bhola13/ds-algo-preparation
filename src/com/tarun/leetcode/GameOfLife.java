package com.tarun.leetcode;

public class GameOfLife {
    // leetcode 289

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        board = gameOfLife(board);
    }

    private static int[][] gameOfLife(int[][] board) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length;j++){
                int activeNeighbour = 0;
                if(board[i][j] == 0){
                     activeNeighbour = getActiveNeighbours(board, i , j, directions);
                     if(activeNeighbour == 3){
                         board[i][j] = 3;
                     }
                }else if(board[i][j] == 1){
                    activeNeighbour = getActiveNeighbours(board,i,j,directions);
                    if(activeNeighbour < 2 || activeNeighbour > 3){
                        board[i][j] = -2;
                    }
                }
            }
        }
        updateBoard(board);
        return board;
    }

    private static void updateBoard(int[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0; j < board[0].length ; j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == -2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private static int getActiveNeighbours(int[][] board, int row, int col, int[][] directions) {
        int activeNeighbours = 0;
        for(int i = 0 ; i < directions.length ; i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if(newRow >= 0 && newRow < board.length && newCol >= 0
                    && newCol < board[0].length
                    && (board[newRow][newCol] == 1 || board[newRow][newCol] == -2)){
                activeNeighbours++;
            }
        }

       return activeNeighbours;
    }


}
