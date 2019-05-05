package com.badalchowdhary.datastructures;

/**
 * TrieNode implementation with array.
 * 
 * @author badalrocks
 *
 */
public class TrieNodeV2
{
    private TrieNodeV2[] children = new TrieNodeV2[26];
    private boolean      endOfWord;

    public TrieNodeV2[] getChildren()
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
