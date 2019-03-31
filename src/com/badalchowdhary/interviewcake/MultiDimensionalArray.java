package com.badalchowdhary.interviewcake;

import java.util.Arrays;

public class MultiDimensionalArray
{

    public static void main(String[] args)
    {
        int [][] matrix = new int[3][3];
        
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[i].length; j++)
            {
                matrix[i][j] = i*j;
            }
        }
        
        System.out.println(Arrays.deepToString(matrix));

    }

}
