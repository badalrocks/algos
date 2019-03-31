package com.badalchowdhary.algos.recursion;

public class Palindrome
{

    public static boolean isPalindrome(String s)
    {
        if (s == null)
            throw new IllegalArgumentException("s cannot be null");

        if (s.length() <= 1)
            return true;

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        String recurseString = s.substring(1, s.length() - 1);

        System.out.println("first: " + first + ", last: " + last + ", recurse: " + recurseString);
        return first == last && isPalindrome(recurseString);

    }

    public static boolean isPalindromeWithSpaces(String s)
    {
        if (s == null)
            throw new IllegalArgumentException("s cannot be null");

        if (s.length() <= 1)
            return true;

        int firstIndex = 0;
        int lastIndex = s.length() - 1;

        while (s.charAt(firstIndex) == ' ')
        {
            firstIndex++;
        }

        while (s.charAt(lastIndex) == ' ')
        {
            lastIndex--;
        }

        char first = s.charAt(firstIndex);
        char last = s.charAt(lastIndex);

        if (firstIndex < lastIndex)
        {
            String recurseString = s.substring(firstIndex + 1, lastIndex);

            System.out.println("first: " + first + ", last: " + last + ", recurse: " + recurseString);
            return first == last && isPalindromeWithSpaces(recurseString);
        }
        else
        {
            return first == last;
        }

    }

    public static void main(String[] args)
    {
        System.out.println(isPalindromeWithSpaces(" n it  i n   "));
    }

}
