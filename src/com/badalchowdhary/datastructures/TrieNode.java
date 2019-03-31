package com.badalchowdhary.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
    private char c;
    private Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
    
    public TrieNode(char c, Map<Character, TrieNode> map)
    {
        this.c = c;
        this.map = map;
    }
    
    public boolean isChildExists(char c)
    {
        return map.get(c) != null;
    }
    
    public void addChild(char c)
    {
        map.put(c, new TrieNode(c, new HashMap<Character, TrieNode>()));
    }
    
    public TrieNode getChild(char c)
    {
        return map.get(c);
    
    }
    

}
