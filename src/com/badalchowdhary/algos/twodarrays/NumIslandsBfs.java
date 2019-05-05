package com.badalchowdhary.algos.twodarrays;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslandsBfs {

    static Queue<Cell> q = new LinkedList<>();
    
    static int getNumberOfIslands(int[][] binaryMatrix) {
      int numIslands = 0;
      if (binaryMatrix == null || binaryMatrix.length == 0) return numIslands;
      
      
      
      for (int row=0; row<binaryMatrix.length; row++)
      {
        for (int col=0; col<binaryMatrix[row].length; col++)
        {
          if (binaryMatrix[row][col] == 1)
          {
            System.out.println(row + " - " + col);
            numIslands++;
            q.offer(new Cell(row, col));      
            markIsland(binaryMatrix, row, col);          
          }
        }
      }
      
      return numIslands;
    }
    
    private static void markIsland(int[][] binaryMatrix, int row, int col)
    {
      while (!q.isEmpty())
      {
        Cell c = q.poll();
        binaryMatrix[c.row][c.col] = 0;
        pushIfValid(c.row+1, c.col, binaryMatrix);
        pushIfValid(c.row-1, c.col, binaryMatrix);
        pushIfValid(c.row, c.col+1, binaryMatrix);
        pushIfValid(c.row, c.col-1, binaryMatrix);
      }
    }
    
    private static void pushIfValid(int row, int col, int[][] binaryMatrix)
    {
      if (row >=0 && row < binaryMatrix.length && col >= 0 && col < binaryMatrix[row].length && binaryMatrix[row][col] == 1)
      {
        q.offer(new Cell(row, col));
        
      }
    }
    
   /* static int getNumberOfIslands(int[][] binaryMatrix) {
      
      if (binaryMatrix == null || binaryMatrix.length == 0)
      {
        return 0;      
      }
      
      int islands = 0;
      boolean[][] visited = new boolean[binaryMatrix.length][binaryMatrix[0].length];
      
      for (int row = 0; row < binaryMatrix.length; row++)
      {
        for (int col=0; col < binaryMatrix[row].length; col++)
        {
          if (binaryMatrix[row][col] == 1 && !visited[row][col])
          {
            islands++;
            dfs(binaryMatrix, row, col, visited);
          }
        }
      }
      
      return islands;    
      
    }
    
    static void dfs(int[][] binaryMatrix, int row, int col, boolean[][] visited)
    {
      if (isValidCell(binaryMatrix, row, col) && binaryMatrix[row][col] == 1 && !visited[row][col])
      {
        visited[row][col] = true;
        dfs(binaryMatrix, row, col-1, visited);
        dfs(binaryMatrix, row, col+1, visited);
        dfs(binaryMatrix, row-1, col, visited);
        dfs(binaryMatrix, row+1, col, visited);
      }
    }
    
    static boolean isValidCell(int[][] binaryMatrix, int row, int col)
    {
      return row >= 0 && row < binaryMatrix.length && col >= 0 && col < binaryMatrix[row].length;
    }
  */
    public static void main(String[] args) {
      
      int[][] binaryMatrix = { {0,    1,    0,    1,    0},
                              {0,    0,    1,    1,    1},
                              {1,    0,    0,    1,    0},
                              {0,    1,    1,    0,    0},
                              {1,    0,    1,    0,    1} };
      
      int islands = getNumberOfIslands(binaryMatrix);
      System.out.println(islands);
      

    }
    
    static class Cell 
    {
      public int row;
      public int col;
      
      public Cell(int row, int col)
      {
        this.row = row;
        this.col = col;
      }
    }


  }

class Cell 
{
  public int row;
  public int col;
  
  public Cell(int row, int col)
  {
    this.row = row;
    this.col = col;
  }
}
