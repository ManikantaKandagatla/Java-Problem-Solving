package com.mywork;
import java.util.HashMap;
/**
 * @author ManiKanta Kandagatla
 */
public class TrieNode
{

    private HashMap<Character,TrieNode> children;
    
    private String meaning;
    
    private String key;
    
    private int count;
    
    public TrieNode(String key)
    {
        this.count = 0;
        this.children = new HashMap<Character,TrieNode>();
        this.key = key;
        this.meaning = null;
    }

    public HashMap<Character, TrieNode> getChildren()
    {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children)
    {
        this.children = children;
    }

    public String getMeaning()
    {
        return meaning;
    }

    public void setMeaning(String meaning)
    {
        this.meaning = meaning;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

}
