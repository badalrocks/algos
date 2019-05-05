package com.badalchowdhary.algos.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        
        if(s == null) return result;
    
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(s);
        visited.add(s);
        boolean found = false;
        int resultLen = 0;
        
        while(!q.isEmpty()) {
            String str = q.poll();
            //System.out.println(str);
            
            if((resultLen == 0 || resultLen == str.length()) && isValid(str)) {
                result.add(str);
                found = true;
                resultLen = str.length();
            }
            
            if(found) continue;
            
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                  System.out.println(str.charAt(i));
                    continue;  
                } 
                String newStr = str.substring(0, i) + str.substring(i + 1);
                if(!visited.contains(newStr)) {
                    visited.add(newStr);
                    q.offer(newStr);
                }
            }
        }
        
        return result;
    }
    
    
    private boolean isValid(String input) {
        int count = 0;
        char[] chArr = input.toCharArray();
        for(char ch : chArr) {
            if(ch == '(') {
                count++;
                continue;
            }
            if(ch == ')') {
                count--;
                if(count < 0) return false;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args)
    {
        RemoveInvalidParenthesis s = new RemoveInvalidParenthesis();
        List<String> result = s.removeInvalidParentheses("()(()");
        System.out.println(result);
    }
}
