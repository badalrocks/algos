package com.badalchowdhary.algos.string;

public class Test
{

    public static void main(String[] args)
    {
        String s = "ABC";
        
        for (int i=0; i<s.length(); i++)
        {
            //int a = 'a';
            //System.out.println((int)s.charAt(i) + " - a: " + a);
            System.out.println(s.charAt(i) - 'A');
        }

    }

}
