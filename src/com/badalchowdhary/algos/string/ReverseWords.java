package com.badalchowdhary.algos.string;

public class ReverseWords
{
    public static void reverseWords(char[] str) {
        
        if (str == null || str.length <=1 ) return;
        
        reverse(str, 0, str.length-1);
        
        int start = 0;
        int end = 0;
        for (int i=0; i<str.length; i++)
        {
            if (str[i] != ' ')
            {
                end++;
            }
            else
            {
                reverse(str, start, end-1);
                
                start = i+1;
                end = i+1;
                
            }
            
        }
        
        
        
    }
    
    private static void reverse(char[] c, int start, int end)
    {
        while (start < end)
        {
            char temp = c[start];
            c[start] = c[end];
            c[end]=temp;
            
            start++;
            end--;
            
        }
    }
    public static void main(String[] args)
    {
        String s = "Hello World";
        reverseWords(s.toCharArray());
        System.out.println(s);

    }

}
