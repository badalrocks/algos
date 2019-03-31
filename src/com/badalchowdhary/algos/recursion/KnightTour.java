package com.badalchowdhary.algos.recursion;

public class KnightTour
{
    private static int N = 16;

    public static boolean getKnightTour()
    {
        int[][] board = new int[N][N];

        int step = 1;
        int row = 0;
        int col = 0;
        
        int[] x = { -1, -2, -2, -1, 1, 2, 2,  1 };
        int[] y = { 2,   1, -1, -2, 2, 1, -1, -2 };
        
        board[0][0] = 1;

        return isKtUtil(board, row, col, x, y, step);

    }

    private static boolean isKtUtil(int[][] board, int row, int col, int[] x, int[] y, int step)
    {
        //System.out.println("row: " + row + ", col: " + col + ", step: " + step);
        if (step == N*N)
        {
            for (int i=0; i<board.length;i++)
            {
                for (int j=0; j<board[i].length; j++)
                {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        
        for (int k=0; k<8;k++)
        {
            int nextRow = row + x[k];
            int nextCol = col + y[k];
            
            if (isSafe(board, nextRow, nextCol))
            {
                board[nextRow][nextCol] = step + 1;
                if (isKtUtil(board, nextRow, nextCol, x, y, step + 1))
                {
                    return true;
                }
                else
                {
                    board[nextRow][nextCol] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col)
    {
        if (row >= 0 && row < N && col >= 0 && col < N && board[row][col] == 0)
        {
            return true;
        }

        else
            return false;

    }

    public static void main(String[] args)
    {
        boolean isKnightTour = getKnightTour();
        System.out.println("isKnightTour: " + isKnightTour);

    }

}
