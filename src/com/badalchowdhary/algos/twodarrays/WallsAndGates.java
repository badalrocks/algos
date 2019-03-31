package com.badalchowdhary.algos.twodarrays;

public class WallsAndGates {
    
    static int inf = 2147483647;
    
    public void wallsAndGates(int[][] rooms) {
        
        for (int row=0; row<rooms.length; row++)
        {
            for (int col=0; col<rooms[row].length; col++)
            {
                if (rooms[row][col] == '0')
                {
                    dfs(rooms, row, col, 0);
                }
            }
        }
        
    }
    
    private void dfs(int[][] rooms, int row, int col, int distance)
    {
        if (!isValidCell(rooms, row, col))
        {
            return;
        }
        
        if (rooms[row][col] == -1)
        {
            return;
        }
        
        if (distance <= rooms[row][col])
        {
            rooms[row][col] = distance;
            dfs(rooms, row+1, col, distance+1);
            dfs(rooms, row-1, col, distance+1);
            dfs(rooms, row, col+1, distance+1);
            dfs(rooms, row, col-1, distance+1);
        }
    }
    
    private boolean isValidCell(int[][] rooms, int row, int col)
    {
        return row >= 0 && row < rooms.length && col >= 0 && col < rooms[row].length;
    }
    public static void main(String[] args)
    {
        int[] [] input = {
                            {2147483647, -1, 0, 2147483647},
                            {2147483647, 2147483647, 2147483647, -1},
                            {2147483647, -1, 2147483647, -1},
                            {0, -1, 2147483647, 2147483647}
                         };
                         
         WallsAndGates o = new WallsAndGates();
         o.wallsAndGates(input);
         
         for (int row=0; row<input.length; row++)
        {
            for (int col=0; col<input[row].length; col++)
            {
                System.out.print(input[row][col] + " ");
            }
            System.out.println();
        }
    }
}