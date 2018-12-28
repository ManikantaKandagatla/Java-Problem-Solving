package com.mywork.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mywork.commons.Trie;
import com.mywork.commons.TrieNode;
/**
 * @author ManiKanta Kandagatla
 */
public class MaxFrequentWord extends Trie
{
    public MaxFrequentWord()
    {
        setMaxFrequency(-1);
        setMaxOccuringString(new ArrayList<String>());
    }

    private int maxFrequency;

    private List<String> maxOccuringString;

    public List<String> getMaxOccuringString()
    {
        return maxOccuringString;
    }

    public void setMaxOccuringString(List<String> maxOccuringString)
    {
        this.maxOccuringString = maxOccuringString;
    }

    public int getMaxFrequency()
    {
        return maxFrequency;
    }

    public void setMaxFrequency(int maxFrequency)
    {
        this.maxFrequency = maxFrequency;
    }

    /**
     * Traverse all the nodes of the trie and in recursion update the max occuring string
     * 
     * @param temp
     */
    public void traverseTrie(TrieNode temp)
    {
        if (temp == null)
            return;
        else
        {
            Iterator<Map.Entry<Character, TrieNode>> it = temp.getChildren().entrySet().iterator();
            while (it.hasNext())
            {
                Entry<Character, TrieNode> entry = it.next();
                int count = entry.getValue().getCount();
                if (count > getMaxFrequency())
                {
                    setMaxFrequency(count);
                    getMaxOccuringString().clear();
                    getMaxOccuringString().add(temp.getChildren().get(entry.getKey()).getKey());
                }
                else if (count == getMaxFrequency())
                {
                    getMaxOccuringString().add(temp.getChildren().get(entry.getKey()).getKey());
                }
                traverseTrie(entry.getValue());
            }
        }
    }

    public void testMaxFrequencyWord()
    {
        String[][] testCases = { { "manikanta", "kanta", "mani", "mani" },
                { "abc", "abc", "xyz", "abc" }, { "abc", "abc", "xyz", "abc", "xyz", "xyz" },
                { "abc", "xyz" } };

        for (int index = 0; index < testCases.length; index++)
        {
            TrieNode root = new TrieNode("");
            for (int j = 0; j < testCases[index].length; j++)
            {
                root = insertTrieNode(root, testCases[index][j]);
            }
            traverseTrie(root);
            System.out.println(
                    "######################################################################");
            System.out.println("Input: " + Arrays.toString(testCases[index]));
            System.out.println(
                    "Max Occuring String: " + Arrays.toString(getMaxOccuringString().toArray()));
            System.out.println("Frequency :" + getMaxFrequency() + "\n");
            setMaxFrequency(-1);
            getMaxOccuringString().clear();
        }

    }

    public static void main(String[] args)
    {
        MaxFrequentWord testObj = new MaxFrequentWord();
        testObj.testMaxFrequencyWord();
    }
}
