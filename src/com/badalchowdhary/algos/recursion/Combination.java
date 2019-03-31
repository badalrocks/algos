package com.badalchowdhary.algos.recursion;

public class Combination
{

    public static void combination(String soFar, String rest)
    {
        if (rest.equals(""))
        {
            System.out.println(soFar);
        }
        else
        {
            String newRest = rest.substring(1);

            // include current character
            combination(soFar + rest.substring(0, 1), newRest);

            // exclude current character
            combination(soFar, newRest);
        }
    }

    public static void combinationWrapper(String input)
    {
        combination("", input);
    }

    public static void main(String[] args)
    {
        String input = "ABC";

        combinationWrapper(input);

    }

}
