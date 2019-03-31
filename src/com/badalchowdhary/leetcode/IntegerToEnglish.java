package com.badalchowdhary.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglish
{
    private static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(0, "");
        map.put(1, " One");
        map.put(2, " Two");
        map.put(3, " Three");
        map.put(4, " Four");
        map.put(5, " Five");
        map.put(6, " Six");
        map.put(7, " Seven");
        map.put(8, " Eight");
        map.put(9, " Nine");
        map.put(10, " Ten");
        map.put(11, " Eleven");
        map.put(12, " Twelve");
        map.put(13, " Thirteen");
        map.put(14, " Fourteen");
        map.put(15, " Fifteen");
        map.put(16, " Sixteen");
        map.put(17, " Seventeen");
        map.put(18, " Eighteen");
        map.put(19, " Nineteen");
        map.put(20, " Twenty");
        map.put(30, " Thirty");
        map.put(40, " Forty");
        map.put(50, " Fifty");
        map.put(60, " Sixty");
        map.put(70, " Seventy");
        map.put(80, " Eighty");
        map.put(90, " Ninety");

    }

    public static String getEnglishWord(int num)
    {
        if (num == 0)
        {
            return "Zero";
        }

        return getEnglishWordHelper(num).trim();
        

    }

    private static String getEnglishWordHelper(int num)
    {
        if (map.containsKey(num))
        {
            return map.get(num);
        }

        if (num < 100)
        {
            return getEnglishWordHelper(num / 10 * 10) + getEnglishWordHelper(num % 10);
        }

        if (num < 1000)
        {
            return getEnglishWordHelper(num / 100) + " Hundred" + getEnglishWordHelper(num % 100);
        }

        if (num < 1000000)
        {
            return getEnglishWordHelper(num / 1000) + " Thousand" + getEnglishWordHelper(num % 1000);
        }
        
        if (num < 1000000000)
        {
            return getEnglishWordHelper(num / 1000000) + " Million" + getEnglishWordHelper(num % 1000000);
        }
        
        if (num <= Integer.MAX_VALUE)
        {
            return getEnglishWordHelper(num / 1000000000) + " Billion" + getEnglishWordHelper(num % 1000000000);
        }

        return null;
    }

    public static void main(String[] args)
    {
        //int num = 100000;
         int num = Integer.MAX_VALUE;
        System.out.println(getEnglishWord(num));

    }

}
