package com.badalchowdhary.algos.string;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        
        int sBackCount = 0;
        int tBackCount = 0;
        
        int i = S.length()-1;
        int j = T.length()-1;
        
        while (i>=0 && j>= 0)
        {
            System.out.println("processing i:" + i + " j:" + j );
            char s1 = S.charAt(i);
            char t1 = T.charAt(j);
            
            if (s1 == '#')
            {
                sBackCount++;
                i--;
            }
            else if (sBackCount > 0)
            {
                sBackCount--;
                i--;
            }
            else if (t1 == '#')
            {
                tBackCount++;
                j--;
            }
            else if (tBackCount > 0)
            {
                tBackCount--;
                j--;
            }
            else if (s1 != t1)
            {
                System.out.println("first return: " + i + " - " + j );
                return false;
            }
            else
            {
                i--;
                j--;
            }
        }
        
         while (i >= 0)
        {
            if (S.charAt(i) == '#')
            {
                sBackCount++;
            }
            else if (sBackCount > 0)
            {
                sBackCount--;
            }
            else 
            {
                return false;
            }
            i--;
        }
        
        while (j >= 0)
        {
            if (T.charAt(j) == '#')
            {
                tBackCount++;
            }
            else if (tBackCount > 0)
            {
                tBackCount--;
            }
            else
            {
                return false;
            }
            j--;
        }
        
        System.out.println("fourth return: " + i + " - " + j );
        
        return i == j;
        
    }
    
    public static void main(String[] args)
    {
        String s = "bxj##tw";
        String t = "bxj###tw";
        
        System.out.println(backspaceCompare(s, t));
        
    }
}