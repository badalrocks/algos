package com.badalchowdhary.algos.recursion;

public class Subsets
{

    public static void subsets(String soFar, String rest)
    {
        if (rest.equals(""))
        {
            System.out.println(soFar);
        }
        else
        {
            // include next char and recurse
            subsets(soFar + rest.charAt(0), rest.substring(1));
            
            // exclude next char and recurse
            subsets(soFar, rest.substring(1));
            
        }
    }
    
    public static void main(String[] args)
    {
        subsets("", "ABCD");
    
    }

}
