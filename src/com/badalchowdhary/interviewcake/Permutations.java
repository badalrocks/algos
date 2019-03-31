package com.badalchowdhary.interviewcake;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Permutations
{
    public static Set<String> getPermutations(String inputString)
    {
        System.out.println("getPermutations: " + inputString);
        // base case
        if (inputString.length() <= 1)
        {
            System.out.println("base case: " + inputString);
            //return new HashSet<>(Collections.singletonList(inputString));
            Set<String> s = new HashSet<String>();
            s.add(inputString);
            return s;
            //return new HashSet<>(Collections.singletonList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        System.out.println("adding permutationsOfAllCharsExceptLast.." + permutationsOfAllCharsExceptLast + ", last char: " + lastChar);
        Set<String> permutations = new HashSet<>();
        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast)
        {
            for (int position = 0; position <= allCharsExceptLast.length(); position++)
            {
                System.out.println(permutationOfAllCharsExceptLast.substring(0, position) + " - "
                + lastChar + " - " + permutationOfAllCharsExceptLast.substring(position));
                
                String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar
                        + permutationOfAllCharsExceptLast.substring(position);
                
                System.out.println("adding in permutations: " + permutation);        
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    public static void main(String[] args)
    {
        String s = "abcd";
        System.out.println(getPermutations(s));
        

    }

}
