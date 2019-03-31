package com.badalchowdhary.interviewcake;

import java.util.HashMap;
import java.util.Map;

public class MapTest
{

    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap();
        map.put(1, 1);
        map.put(2, 1);
        map.put(1, 2);
        
/*        if (null > 10)
        {
            System.out.println("not found");
        }*/
        
        System.out.println(map);
        

    }

}
