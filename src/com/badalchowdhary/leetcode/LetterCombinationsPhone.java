package com.badalchowdhary.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhone
{

    public static List<String> getLetterCombinations(String digits)
    {
        List<String> combinations = new ArrayList<>();

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String pathSoFar = "";

        getLetterCombinationsHelper(digits, combinations, pathSoFar, mapping);

        return combinations;

    }

    private static void getLetterCombinationsHelper(String digits, List<String> combinations, String pathSoFar,
            String[] mapping)
    {   
        for (int i=0; i<pathSoFar.length(); i++)
        {
            System.out.print("    ");
        }
        System.out.println("digits: " + digits + ", pathSoFar: " + pathSoFar);
    
        if (digits.length() == 0)
        {
            combinations.add(pathSoFar);
            return;
        }
        
        String first = String.valueOf(digits.charAt(0));
        String restOfWord = digits.substring(1);
        
        String letters = mapping[Integer.valueOf(first)];
        
        for (int i=0; i<letters.length(); i++)
        {
            getLetterCombinationsHelper(restOfWord, combinations, pathSoFar + letters.charAt(i), mapping);
        }

    }

    public static void main(String[] args)
    {
        List<String> letterCombinations = getLetterCombinations("23");
        
        System.out.println(letterCombinations);

    }

}
