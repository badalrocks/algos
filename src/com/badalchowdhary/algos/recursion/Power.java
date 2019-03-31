package com.badalchowdhary.algos.recursion;

public class Power
{

    public static int getPower(int base, int exponent)
    {
        System.out.println("base: " + base + ", exponent: " + exponent);
        if (exponent < 0)
            throw new IllegalArgumentException("Exponenet cannot be negative");

        if (exponent == 0)
            return 1;

        return base * getPower(base, exponent - 1);
    }
    
    public static int getPower2(int base, int exponent)
    {
        System.out.println("base: " + base + ", exponent: " + exponent);
        if (exponent < 0) throw new IllegalArgumentException("exponent cannot be negative");
        
        if (exponent == 0) return 1;
        
        if (exponent % 2 == 0)
        {
            // even
            return getPower2(base, exponent/2) * getPower2(base, exponent/2);
        }
        else
        {
            // odd
            return getPower2(base, exponent/2) * getPower2(base, exponent/2) * base;
        }
        
    }
    
    public static int getPower3(int base, int exponent, int[] expResult)
    {
        //System.out.println("base: " + base + ", exp: " + exponent);
    
        if (expResult[exponent] != 0)
        {
            System.out.println("returning from memo. base: " + base + ", exp: " + exponent);
            return expResult[exponent];
        }
        
        System.out.println("computing. base: " + base + ", exp: " + exponent);
        
        if (exponent % 2 == 0)
        {
            // even
            int result = getPower3(base, exponent/2, expResult) * getPower3(base, exponent/2, expResult);
            expResult[exponent] = result; 
            return result;
        }
        else
        {
            // odd
            int result = getPower3(base, exponent/2, expResult) * getPower3(base, exponent/2, expResult) * base;
            expResult[exponent] = result;
            return result;
        }
        
    }
    
    public static void main(String[] args)
    {
        System.out.println("power1");
        System.out.println(getPower(3, 8));
        
        System.out.println("power2");
        System.out.println(getPower2(3, 8));
        
        System.out.println("power3");
        int base = 3;
        int exp = 8;
        int[] expResult = new int[exp+1];
        expResult[0] = 1;
        
        System.out.println(getPower3(base, exp, expResult));
        
    }

}
