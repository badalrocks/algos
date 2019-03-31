package com.badalchowdhary.leetcode;

public class ValidNumber
{

    public static boolean isNumber(String s)
    {
        if (s == null || s.length() == 0)
            return false;

        int startIndex = 0;
        int endIndex = s.length() - 1;
        boolean isExpSeen = false;
        boolean isDotSeen = false;
        int expIndex = -1;
        int dotIndex = -1;
        int lastDigitIndex = -1;

        // leading space.
        while (startIndex <= endIndex && s.charAt(startIndex) == ' ')
        {
            startIndex++;
        }

        // trailing space.
        while (endIndex >= startIndex && s.charAt(endIndex) == ' ')
        {
            endIndex--;
        }

        char currentChar = ' ';
        // first char after spaces.
        if (startIndex <= endIndex)
        {
            currentChar = s.charAt(startIndex);

            if (Character.isDigit(currentChar))
            {
                lastDigitIndex = startIndex;
                startIndex++;
            }
            else if (currentChar == '.')
            {
                isDotSeen = true;
                dotIndex = startIndex;
                startIndex++;
            }
            else if (currentChar == '+' || currentChar == '-')
            {
                startIndex++;
            }
            else
            {
                return false;
            }
        }

        for (int i = startIndex; i <= endIndex; i++)
        {
            currentChar = s.charAt(i);

            if (Character.isDigit(currentChar))
            {
                lastDigitIndex = i;
                continue;
            }
            else if (currentChar == '.')
            {
                if (isDotSeen || isExpSeen)
                {
                    return false;
                }

                isDotSeen = true;
            }
            else if (currentChar == 'e')
            {
                if (isDotSeen || isExpSeen)
                {
                    return false;
                }

                isExpSeen = true;
                expIndex = i;

            }
            else
            {
                return false;
            }
        }

        if (isExpSeen && lastDigitIndex <= expIndex)
        {
            return false;
        }

        if (isDotSeen && lastDigitIndex <= dotIndex)
        {
            return false;
        }

        if (lastDigitIndex == -1)
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isNumber("46.e3"));

    }

}
