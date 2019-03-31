package com.badalchowdhary.algos.recursion;

public class Permute2
{

    public static void permute2(String soFar, String rest)
    {
        if (rest.equals(""))
        {
            System.out.println(soFar);
            return;
        }

        for (int i = 0; i < rest.length(); i++)
        {
            String newSoFar = soFar + rest.charAt(i);
            //String newSoFar = soFar + rest.substring(i, i+1);
            // don't forget 1st part in rest concatenation.
            String newRest = rest.substring(0, i) + rest.substring(i + 1);
            permute2(newSoFar, newRest);
        }

    }

    public static void main(String[] args)
    {
        String test = "ABC";
        permute2("", test);

    }

}
