package com.badalchowdhary.interviewcake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Write an efficient method that tells us whether or not an input string's
 * openers and closers are properly nested.
 * 
 * Examples:
 * 
 * "{ [ ] ( ) }" should return true 
 * "{ [ ( ] ) }" should return false 
 * "{ [ }" should return false
 * 
 * @author badalrocks
 *
 */
public class Problem29BracketValidator
{

    public static boolean areBracketsValid(String brackets)
    {
        // TODO 
        if (!doBoundaryChecks(brackets))
        {
            return false;
        }
        
        Map<Character, Character> closersToOpeners = new HashMap<Character, Character>();
        closersToOpeners.put(')', '(');
        closersToOpeners.put('}', '{');
        closersToOpeners.put(']', '[');
        
        Collection<Character> openers = closersToOpeners.values();
        
        Stack<Character> unclosedOpeners = new Stack<Character>();
        
        for (char c : brackets.toCharArray())
        {
            if (openers.contains(c))
            {
                unclosedOpeners.push(c);
            }
            else
            {
                if (unclosedOpeners.isEmpty())
                {
                    return false;
                }
                
                char lastUnclosedOpener = unclosedOpeners.pop();
                if (lastUnclosedOpener != closersToOpeners.get(c))
                {
                    return false;
                }
            }
        }
        
        return unclosedOpeners.isEmpty();
    }
                   
    private static boolean doBoundaryChecks(String brackets)
    {
        if (brackets == null)
        {
            throw new IllegalArgumentException("brackets is null.");
        }
    
        if (brackets.length() % 2 == 1)
        {
            return false;
        }
        
        return true;
        
    }                 
        
        
        
    

    public static void main(String[] args)
    {
        String brackets1 = "([{}])";
        System.out.println(areBracketsValid(brackets1));
        
        String brackets2 = "([{}]))";
        System.out.println(areBracketsValid(brackets2));
        
        String brackets3 = "([{]})";
        System.out.println(areBracketsValid(brackets3));

    }

}
