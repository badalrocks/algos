package com.badalchowdhary.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * TrieNode implementation with Map.
 * 
 * @author badalrocks
 *
 */
public class TrieNode
{
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean                  endOfWord;

    public Map<Character, TrieNode> getChildren()
    {
        return this.children;
    }

    public boolean isEndOfWord()
    {
        return this.endOfWord;
    }

    public void setEndOfWord(boolean endOfWord)
    {
        this.endOfWord = endOfWord;
    }

}
