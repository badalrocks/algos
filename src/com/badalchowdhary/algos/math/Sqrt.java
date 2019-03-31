package com.badalchowdhary.algos.math;

public class Sqrt
{

//    public static int mySqrt(int x) {
//        
//        
//        
//        for (int i=0;i<=x;i++)
//        {
//            if (i*i == x) return i;
//            long l = (i+1)*(i+1);
//            if (l > x) return i;
//        }
//        
//        
//        return -1;
//        
//    }
    
    
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        if(x == Integer.MAX_VALUE)
            System.out.println("Max Value");;
//        int left = 1, right = Integer.MAX_VALUE;
        int left = 1, right = x;
        
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    
    public static void main(String[] args)
    {
        //System.out.println(LONG.MAX_VALUE);
        int x = mySqrt(36);
        System.out.println(x);
        /*if (46341 * 46341 < 2147483647) {
            System.out.println("Got it");
        } else System.out.println("didn't work");*/

    }

}
