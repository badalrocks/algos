package com.badalchowdhary.algos.twodarrays;

public class TwoDArray
{

    public static int[][] create2DArray()
    {
        // 2d array of 4x4.
        /*
        1  2  3  4
        5  6  7  8
        9  10 11 12
        13 14 15 16
        */
        
        int[][] arr = new int[4][4];
        for (int i=0; i<arr.length; i++)
        {
            for (int j=0; j<arr[i].length; j++)
            {
                arr[i][j] = (4*i) + j + 1;
            }
        }
        
        
        return arr;
    }
    
    public static void print2DArr(int[][] arr)
    {
        for (int i=0; i<arr.length; i++)
        {
            for (int j=0; j<arr[i].length; j++)
            {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    
    }
    
    public static int[][] transpose(int[][] matrix)
    {
        System.out.println("Transposing:");
        int[][] result = new int[matrix[0].length][matrix.length];
        
        for (int row=0; row<matrix.length; row++)
        {
            for (int col=0; col<matrix[row].length; col++)
            {
                result[col][row] = matrix[row][col];
            }
        }
        
        return result;
    }
    
    
    public static void reverseMatrixInPlace(int[][] matrix)
    {
        System.out.println("Reversing in place:");
        for (int row=0; row<matrix.length; row++)
        {
            for (int col=0; col<matrix[row].length/2; col++)
            {
                swapCellInPlace(matrix, row, col, row, matrix[row].length - 1 - col);
            }
        }
    }
    
    
    public static void transposeInPlace(int[][] matrix)
    {
        System.out.println("Transposing in place:");
        for (int row=0; row<matrix.length; row++)
        {
            for (int col=row; col<matrix[row].length; col++)
            {
                if (row != col)
                {
                    swapCellInPlace(matrix, row, col, col, row);
                }
            }
        }
    }
    
    private static void swapCellInPlace(int[][] matrix, int row1, int col1, int row2, int col2)
    {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
    

    public static void main(String[] args)
    {
        int[][] arr = create2DArray();
        print2DArr(arr);
        
        //int[][] transponsed = transpose(arr);
        transposeInPlace(arr);
        reverseMatrixInPlace(arr);
        print2DArr(arr);

    }

}
