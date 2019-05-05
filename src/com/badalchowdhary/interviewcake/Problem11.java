package com.badalchowdhary.interviewcake;

import java.util.HashMap;

import com.badalchowdhary.datastructures.TrieNodeOld;

/*
 * I wrote a crawler that visits web pages, stores a few keywords in a database, and follows links to other web pages. I noticed that my crawler was wasting a lot of time visiting the same pages over and over, so I made a hash set, visited, where I'm storing URLs I've already visited. Now the crawler only visits a URL if it hasn't already been visited.

Thing is, the crawler is running on my old desktop computer in my parents' basement (where I totally don't live anymore), and it keeps running out of memory because visited is getting so huge.

How can I trim down the amount of space taken up by visited?
*/

public class Problem11
{
    private TrieNodeOld root      = new TrieNodeOld(Character.MIN_VALUE, new HashMap<Character, TrieNodeOld>());
    private char     delimiter = '\0';

    public boolean addUrl(String url)
    {
        TrieNodeOld current = root;
        for (int i = 0; i < url.length(); i++)
        {
            char c = url.charAt(i);

            if (!current.isChildExists(c))
            {
                current.addChild(c);
            }

            current = current.getChild(c);
        }

        boolean isNewUrl = false;

        if (!current.isChildExists(delimiter))
        {
            current.addChild(delimiter);
            isNewUrl = true;
        }

        return isNewUrl;
    }

    public static void main(String[] args)
    {
        Problem11 o = new Problem11();
        String url1 = "http://google.com";
        String url2 = "http://google.com/maps";
        String url3 = "http://google.com/ma";
        String url4 = "http://maps.google.com";
        String url5 = "http://google.com";
        String url6 = "http://google.com/maps";
        String url7 = "http://facebook.com";
        String url8 = "http://google.com/mapss";

        System.out.println(o.addUrl(url1));
        System.out.println(o.addUrl(url2));
        System.out.println(o.addUrl(url3));
        System.out.println(o.addUrl(url4));
        System.out.println(o.addUrl(url5));
        System.out.println(o.addUrl(url6));
        System.out.println(o.addUrl(url7));
        System.out.println(o.addUrl(url8));

    }

}
