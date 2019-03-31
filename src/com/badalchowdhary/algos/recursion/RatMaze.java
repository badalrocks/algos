package com.badalchowdhary.algos.recursion;

import com.badalchowdhary.algos.twodarrays.TwoDArray;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the
 * upper left most block i.e., maze[0][0] and destination block is lower
 * rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to
 * reach the destination. The rat can move only in two directions: forward and
 * down. In the maze matrix, 0 means the block is a dead end and 1 means the
 * block can be used in the path from source to destination.
 */
public class RatMaze
{
    public static boolean getRatPath(int[][] maze)
    {
        int[][] sol = new int[maze.length][maze.length];
        
        int row = 0;
        int col = 0;
        
        sol[0][0] = 1;
        
        return getRatPathUtil(maze, sol, row, col);
        
    }

    private static boolean getRatPathUtil(int[][] maze, int[][] sol, int row, int col)
    {
        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1)
        {
            sol[row][col] = 1;
            TwoDArray.print2DArr(sol);
            return true;
        }

        if (isSafe(maze, row, col))
        {
            sol[row][col] = 1;

            // move right.
            if (getRatPathUtil(maze, sol, row, col + 1))
            {
                return true;
            }

            // if right was not successful, then move down.
            if (getRatPathUtil(maze, sol, row + 1, col))
            {
                return true;
            }

            // if both didn't work, then backtrack.
            sol[row][col] = 0;
            //return false;

        }

        return false;

    }

    private static boolean isSafe(int[][] maze, int row, int col)
    {
        return row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 1;
    }

    public static void main(String[] args)
    {
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 0, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } };
                         
        System.out.println(getRatPath(maze));

    }

}
