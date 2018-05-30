package com.mywork;

import java.util.Set;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class StringWildcardSearch extends Trie
{

    /**
     * 
     */
    public StringWildcardSearch()
    {
        // TODO Auto-generated constructor stub
    }

    public boolean searchTrie(TrieNode root, String key, int start, int end)
    {
        boolean found = false;
        TrieNode temp = root;
        if (root == null)
            return false;
        else
        {
            int i;
            for (i = start; i <= end; i++)
            {
                char ch = key.charAt(i);
                if (ch != '.')
                {
                    if (temp.getChildren().containsKey(ch))
                    {
                        temp = temp.getChildren().get(ch);
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    Set<Character> children = temp.getChildren().keySet();
                    // System.out.println(children);
                    if (start == 0)
                    {
                        for (char c : children)
                        {
                            if (temp.getChildren().get(c) != null)
                            {
                                Set<Character> children2 = temp.getChildren().get(c).getChildren()
                                        .keySet();
                                for (char grandchild : children2)
                                {
                                    TrieNode temp2 = temp.getChildren().get(c).getChildren()
                                            .get(grandchild);
                                    found = searchTrie(temp2, key, i + 2, end);
                                    if (found)
                                        return true;
                                }
                            }
                        }
                    }
                    else
                    {
                        for (char c : children)
                        {
                            temp = temp.getChildren().get(c);
                            found = searchTrie(temp, key, i + 1, end);
                            if (found)
                                return true;
                        }
                    }
                }
            }
            // if the traversal reaches till the end of string and current trie node is a leaf node,
            // then exact string match occurred
            if (i == end + 1)
            {
                found = temp.getChildren().size() == 0 ? true : false;
            }
        }
        return found;
    }

    /**
     * @param args
     */
    public void runTestCases()
    {
        String[][] testCases = {
                { "manikanta", "kanta", "manik", "bhimavaram", "hyderabad", "uyder", "bhimadolu" },
                { "..nik", "man.kan.a", "h.......d", "hyderabad", "hyderabas", ".y...", "bhima....",
                        ".....", "..",".....varam" } };
        TrieNode root = new TrieNode("");
        for (int j = 0; j < testCases[0].length; j++)
        {
            root = insertTrieNode(root, testCases[0][j]);
        }
        for (int index = 0; index < testCases[1].length; index++)
        {
            System.out.print(testCases[1][index] + " "
                    + searchTrie(root, testCases[1][index], 0, testCases[1][index].length() - 1)+ "\n");
        }

    }

    public static void main(String[] args)
    {
        StringWildcardSearch testObj = new StringWildcardSearch();
        testObj.runTestCases();
    }
}
