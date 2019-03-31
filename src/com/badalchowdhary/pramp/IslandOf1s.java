package com.badalchowdhary.pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IslandOf1s
{

    public static int getIslandCount(int[][] binaryIsland)
    {
        // TODO boundary checks.
        int islandCount = 0;

        Set<String> sameIsland = new HashSet<>();

        for (int row = 0; row < binaryIsland.length; row++)
        {
            for (int col = 0; col < binaryIsland[row].length; col++)
            {
                //System.out.println("processing: " + row + "-" + col);
                int currentCell = binaryIsland[row][col];
                if (currentCell == 1)
                {
                    if (sameIsland.contains(row + "-" + col))
                    {
                        continue;
                    }

                    islandCount++;

                    List<String> neighbors = getNeighbors(row + "-" + col, binaryIsland);

                    for (String neighbor : neighbors)
                    {
                        processNeighbor(neighbor, sameIsland, binaryIsland);
                    }

                }

            }
        }

        return islandCount;

    }

    private static void processNeighbor(String neighbor, Set<String> sameIsland, int[][] binaryIsland)
    {
        Stack<String> exhaustNeighbors = new Stack<>();
        exhaustNeighbors.push(neighbor);

        while (!exhaustNeighbors.isEmpty())
        {
            neighbor = exhaustNeighbors.pop();
            sameIsland.add(neighbor);

            List<String> neighbors = getNeighbors(neighbor, binaryIsland);

            for (String n : neighbors)
            {
                if (!sameIsland.contains(n))
                {
                    exhaustNeighbors.push(n);
                }
            }
        }
    }

    private static List<String> getNeighbors(String cell, int[][] binaryIsland)
    {
        List<String> neighbors = new ArrayList<>();
        String[] parts = cell.split("-");
        int row = Integer.valueOf(parts[0]);
        int col = Integer.valueOf(parts[1]);

        if (isValidNeighbor(row, col - 1, binaryIsland))
        {
            neighbors.add(row + "-" + (col - 1));
        }

        if (isValidNeighbor(row, col + 1, binaryIsland))
        {
            neighbors.add(row + "-" + (col + 1));
        }

        if (isValidNeighbor(row - 1, col, binaryIsland))
        {
            neighbors.add(row - 1 + "-" + (col));
        }

        if (isValidNeighbor(row + 1, col, binaryIsland))
        {
            neighbors.add(row + 1 + "-" + (col));
        }

        return neighbors;
    }

    private static boolean isValidNeighbor(int row, int col, int[][] binaryIsland)
    {
        if (row < 0 || row >= binaryIsland.length || col < 0 || col >= binaryIsland[row].length)
        {
            return false;
        }

        return binaryIsland[row][col] == 1;

    }

    public static void main(String[] args)
    {
        int[][] binaryMatrix = { { 0, 1, 0, 1, 0 }, { 0, 0, 1, 1, 1 }, { 1, 0, 0, 1, 0 }, { 0, 1, 1, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println(getIslandCount(binaryMatrix));

    }

}
