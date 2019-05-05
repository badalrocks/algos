package com.badalchowdhary.datastructures;

import java.util.Map;

/**
 * Trie implementation using Map.
 * 
 * @author badalrocks
 *
 */
public class Trie
{

    private TrieNode root;

    public Trie()
    {
        this.root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            current = current.getChildren().computeIfAbsent(c, key -> new TrieNode());
        }

        current.setEndOfWord(true);
    }

    public boolean search(String word)
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            Map<Character, TrieNode> children = current.getChildren();
            if (!children.containsKey(c))
            {
                return false;
            }

            current = children.get(c);

        }

        return current.isEndOfWord();

    }

    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("Hello");
        t.insert("World");
        System.out.println("abc: " + t.search("abc"));
        System.out.println("World: " + t.search("World"));
        System.out.println("World1: " + t.search("World1"));
        System.out.println("Worl: " + t.search("Worl"));

    }

}
