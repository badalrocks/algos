package com.badalchowdhary.interviewcake;

import java.util.HashSet;
import java.util.Set;

/*Write a method that takes an integer flightLength (in minutes) and 
 * an array of integers movieLengths (in minutes) and 
 * returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.*/

public class Problem14TwoSum
{
    public static boolean twoMoviesExist(int flightLength, int[] movieLengths)
    {
        // TODO boundary checks.
        // doBoundaryChecks(flightLength, movieLengths);
        Set<Integer> movieLengthsSeen = new HashSet<Integer>();
        
        for (int firstMovieLength : movieLengths)
        {
            int matchingSecondMovieLength = flightLength - firstMovieLength;
            
            if (movieLengthsSeen.contains(matchingSecondMovieLength))
            {
                return true;
            }
            
            movieLengthsSeen.add(firstMovieLength);
        
        }
        
        return false;
        
    }

    public static void main(String[] args)
    {
        int flightLength = 100;
        int[] movieLengths = {50, 40, 60, 71, 51};
        
        System.out.println(twoMoviesExist(flightLength, movieLengths));

    }

}
