package com.mywork.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ManiKanta Kandagatla
 */
public class UniqueCharactersInString
{

    private static String getUniqueCharacters(String s)
    {
        if (s == null || s == "")
            return s;
        else
        {
            StringBuilder op= new StringBuilder("");
            char[] charArr = s.toCharArray();
            Set<Character> charSet = new HashSet<>();
            for(char ch: charArr) 
            {
                if(!charSet.contains(ch))
                {
                    op.append(ch);
                    charSet.add(ch);
                }
            }
            return op.toString();
        }
    }

    public static void runTestCases()
    {
        String[] testCases = { "manikanta", "aaaabc", "aaaaaa", "", "mmaanniikkanntaa", "MaAnNikantTa" };
        for(String tc: testCases)
        {
            System.out.println("Input: "+ tc);
            System.out.println("Unique char String(Case sensitive): "+ getUniqueCharacters(tc)+"\n\n");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        runTestCases();
    }

}
