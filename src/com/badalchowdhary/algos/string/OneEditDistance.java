package com.badalchowdhary.algos.string;

public class OneEditDistance
{

    public static boolean isOneEditDistance(String s, String t)
    {

        if (Math.abs(s.length() - t.length()) > 1)
        {
            return false;
        }

        int commonPrefixChars = 0;
        int commonSuffixChars = 0;

        int i = 0;
        int j = 0;

        // System.out.println("a == A: " + 'a' == 'A');

        while (i < s.length() && j < t.length())
        {
            if (s.charAt(i) != t.charAt(j))
            {
                break;
            }

            i++;
            j++;
            commonPrefixChars++;
        }

        i = s.length() - 1;
        j = t.length() - 1;

        while (i >= commonPrefixChars && j >= commonPrefixChars)
        {
            if (s.charAt(i) != t.charAt(j))
            {
                break;
            }

            i--;
            j--;
            commonSuffixChars++;
        }

        System.out.println("commonPrefixChars: " + commonPrefixChars + " , commonSuffixChars: " + commonSuffixChars);

        return commonPrefixChars + commonSuffixChars == Math.max(s.length(), t.length()) - 1;

    }

    public static void main(String[] args)
    {
        String s = "ab";
        String t = "acb";
        
        isOneEditDistance(s, t);
    }
}
