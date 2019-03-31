package com.badalchowdhary.algos.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis
{

    public static boolean isValid(String s)
    {

        if (s == null || s.length() % 2 != 0)
        {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // parse string.
        // if not closing char, then add in stack.
        // if closing char, then pop from stack and compare with value in map.
        // if not match then return false.
        // in end, check stack size = 0;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (map.get(c) == null)
            {
                stack.push(c);
            }
            else
            {
                char popped = stack.pop();
                if (map.get(c) != popped)
                {
                    return false;
                }
            }
        }

        return stack.size() == 0;

    }

    public static void main(String[] args)
    {
        String s = "()";
        System.out.println(isValid(s));

        // TODO Auto-generated method stub

    }

}
