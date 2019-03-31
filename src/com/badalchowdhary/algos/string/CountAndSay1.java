package com.badalchowdhary.algos.string;

public class CountAndSay1
{

    public static void main(String[] args)
    {
        System.out.println(countAndSay(8));

    }

    public static String countAndSay(int n)
    {

        if (n < 0) return null;
        if (n == 1) return "1";
        if (n == 2) return "11";

        String base = "11"; // 21 // 1211
        for (int i = 3; i <= n; i++)
        {
            char previous = base.charAt(0);
            int count = 1;
            String intermediate = "";
            char current=0;

            for (int j = 1; j < base.length(); j++)
            {
                current = base.charAt(j);

                if (previous == current)
                {
                    count++;
                }
                else
                {
                    intermediate += count + "" + previous;
                    previous = current;
                    count = 1;

                }

                //intermediate += count + "" + current;

            }

            base = intermediate + count + "" + current;

        }
        return base;

    }

}
