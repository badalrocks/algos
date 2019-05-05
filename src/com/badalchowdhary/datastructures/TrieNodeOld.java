package com.badalchowdhary.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeOld
{
    private char c;
    private Map<Character, TrieNodeOld> map = new HashMap<Character, TrieNodeOld>();
    
    public TrieNodeOld(char c, Map<Character, TrieNodeOld> map)
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
        map.put(c, new TrieNodeOld(c, new HashMap<Character, TrieNodeOld>()));
    }
    
    public TrieNodeOld getChild(char c)
    {
        return map.get(c);
    
    }
    

}
