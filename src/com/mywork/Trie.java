package com.mywork;

/**
 * @author ManiKanta Kandagatla
 */
public class Trie
{
    public Trie()
    {
        
    }

    /**
     * Utility function to insert a String into given trie
     * 
     * @param root
     * @param s
     * @return
     */
    public TrieNode insertTrieNode(TrieNode root, String s)
    {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (temp.getChildren().get(ch) == null)
            {
                temp.getChildren().put(ch, new TrieNode(s.substring(0,i+1)));
            }
            temp = temp.getChildren().get(ch);
        }
        temp.setKey(s);
        temp.setCount(temp.getCount() + 1);
        return root;
    }

    public boolean searchTrie(TrieNode root, String key)
    {
        // Need to update this
        return false;
    }
}
