package com.badalchowdhary.algos.bitwise;

public class BitwiseOperations
{
    /**
     * Bitwise & helps in determining if number is even or odd. if (x & 1 == 0)
     * then x is even. else x is odd.
     * 
     * @param x
     * @return
     */
    public static String isOddOrEven(int x)
    {

        int result = x & 1;
        System.out.println(result);

        if (result == 0)
        {
            return "even";
        }
        else
        {
            return "odd";
        }

    }

    /**
     * Left shifting a number by n, multiplies the number by 2^n. Thus left
     * shifting a number by 1, multiplies the number by 2^1. Works for both
     * positive and negative numbers.
     * 
     * @param x
     * @param pow.
     *            cannot be negative.
     * @return
     */
    public static int multiplyByPowerOf2(int x, int pow)
    {
        return x << pow;
    }

    /**
     * Right shifting a number by n, divides the number by 2^n. Thus right
     * shifting a number by 1, will divide the number by 2^1. Works for both
     * positive and negative numbers.
     * 
     * @param x
     * @param pow
     * @return
     */
    public static int divideByPowerOf2(int x, int pow)
    {
        return x >> pow;
    }

    public static void main(String[] args)
    {

        // String oddOrEven = isOddOrEven(0); System.out.println(oddOrEven);

        // int x = 10;
        // System.out.println(multiplyByPowerOf2(x, 2));

        int x = -10;
        System.out.println(divideByPowerOf2(x, 1));
    }

}
