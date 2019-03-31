package com.badalchowdhary.interviewcake;

import java.math.BigInteger;

/*
 * Write a method fib() that takes an integer n and returns the nth Fibonacci number.
 */
public class Problem15Fib
{

    // use BigInteger as return type as int & long will quickly overflow.
    public static BigInteger fib(int n)
    {
        // TODO boundary checks.
        doBoundaryChecks(n);
        
        if (n == 0 || n == 1 )
        {
            return BigInteger.valueOf(n);
        }
        
        BigInteger secondLastFib = BigInteger.valueOf(0);
        BigInteger lastFib = BigInteger.valueOf(1);
        BigInteger fib = BigInteger.valueOf(0);
        
        for (int i=2; i<=n; i++)
        {
            fib = lastFib.add(secondLastFib);
            secondLastFib = lastFib;
            lastFib = fib;
        }
        
        return fib;
        
    }
    
    private static void doBoundaryChecks(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException ("n must be greater than or equal to 0.");
        }
    
    }
    
    
    

    public static void main(String[] args)
    {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(5));
        System.out.println(fib(10));
        System.out.println(fib(20));
        System.out.println(fib(50));
        System.out.println(fib(70));
        System.out.println(fib(80));
        System.out.println(fib(90));
        System.out.println(fib(99));
        System.out.println(fib(100));
        System.out.println(fib(120));

    }

}
