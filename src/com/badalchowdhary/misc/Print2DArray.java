package com.badalchowdhary.misc;

public class Print2DArray
{

    public static void main(String[] args)
    {
        int[][] matrix = new int[4][4];
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[row].length; col++)
            {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }


}
