package com.badalchowdhary.algos.string;

public class CountAndSay
{

    
    public static void main(String[] args)
    {
       System.out.println("RESULT: "+countAndSay(4));
    }

    
 public static String countAndSay(int n) {
        
        // for loop over n.
         String result = "1";
     
        
        if (n <= 0) return null;
        
       
        for(int j =n-1; j>0; j--) {
           
            String cur = "";
            for (int i = 0; i < result.length(); i++) {
                int count = 1;
                 while ((i + 1 < result.length()) && (result.charAt(i) == result.charAt(i + 1))){
                    count++;    
                    i++;
                }
                cur+= count+ "" + result.charAt(i);
            }
            result= cur;
        }
        return result;
        
        
 }
 
}
