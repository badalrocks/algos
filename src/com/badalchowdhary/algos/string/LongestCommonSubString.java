package com.badalchowdhary.algos.string;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubString
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        String str = "abcbabefgb";
        String str = "abcaa";
        
        System.out.println(longestSubString(str));

    }
    //

    public static String longestSubString(String str){
     
        Map<Character, Integer> map = new HashMap<Character, Integer> ();
        String result = "";
        int sub_len = 1; 
       
        String intSubStr = ""+str.charAt(0);
        char prev = ' ';
        char current = ' ';
        
        int prevVal = 0;
        int currentVal = 0;
        
    
      
        for (int i=0; i < str.length(); i++){
            
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i),  map.get(str.charAt(i-1))+1);
            
            //abcbabefgb
            if(i>0){
                
                prev = str.charAt(i-1);
                current = str.charAt(i); 
                
                prevVal= map.get(str.charAt(i-1));
                currentVal = map.get(str.charAt(i));
               
                
                if (prevVal <= currentVal && prev != current){
//                    sub_len=sub_len;
                    intSubStr=intSubStr+current;
                }
                else{
//                    sub_len = 1;
                    
                    intSubStr = ""+prev;
                }
                
            }
                        
            }
            
        
        return result;
        
    }
    
}
