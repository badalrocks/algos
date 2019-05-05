package com.badalchowdhary.datastructures;

public class TrieV2
{
    private TrieNodeV2 root = new TrieNodeV2();
    
    public void insert(String word)
    {
        TrieNodeV2 current = root;
        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            
            TrieNodeV2[] children = current.getChildren();
            if (children[c - 'a'] == null)
            {
                children[c - 'a'] = new TrieNodeV2();
            }
            
            current = children[c - 'a'];
        }
        
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) 
    {
        TrieNodeV2 current = root;
        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            TrieNodeV2[] children = current.getChildren();
            if (children[c - 'a'] == null)
            {
                return false;
            }
            
            current = children[c - 'a'];
        }
        
        return current.isEndOfWord();
    }

    public static void main(String[] args)
    {
        // all lower case.
        TrieV2 t = new TrieV2();
        t.insert("hello");
        t.insert("world");
        System.out.println("abc: " + t.search("abc"));
        System.out.println("World: " + t.search("world"));
        System.out.println("World1: " + t.search("worlda"));
        System.out.println("Worl: " + t.search("worl"));
    }
    

}
