package com.mywork.strings;

import java.util.Arrays;

/**
 * 
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
import java.util.HashMap;

public class CharsCommonInListOfStrings
{
    public String[][] testCases = { { "abcdefghi", "abcde", "ab", "bas", "axyz" },
            { "ManiKanta is from Bhimavaram, West Godavari", "Bhimavaram West Godavari" } };

    /**
     * Function returns no.of characters common in a list of strings. Implemented using hashmap of
     * level count i.e.
     * 
     * @param arr
     * @return
     */
    public int getCharsCommonInStrings(String[] arr)
    {
        HashMap<Character, HashMap<Integer, Integer>> charCountMap = new HashMap<Character, HashMap<Integer, Integer>>();
        int level = 1;
        int count = 0;
        HashMap<Integer, Integer> countLevel;
        String keys = "";
        for (String str : arr)
        {
            for (int index = 0; index < str.length(); index++)
            {
                if (charCountMap.get(str.charAt(index)) == null)
                {
                    countLevel = new HashMap<Integer, Integer>();
                    countLevel.put(level, 1);
                    charCountMap.put(str.charAt(index), countLevel);
                    keys += str.charAt(index);
                }
                else
                {
                    if (charCountMap.get(str.charAt(index)).get(level) == null)
                        charCountMap.get(str.charAt(index)).put(level, 1);
                    else
                    {
                        count = (int) charCountMap.get(str.charAt(index)).get(level);
                        count++;
                        charCountMap.get(str.charAt(index)).put(level, count);
                    }

                }
            }
            level = level + 1;
        }
        count = 0;
        for (int index = 0; index < keys.length(); index++)
        {
            if (charCountMap.get(keys.charAt(index)).values().size() == level - 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int result = -1;
        CharsCommonInListOfStrings charsCommon = new CharsCommonInListOfStrings();
        for (int i = 0; i < charsCommon.testCases.length; i++)
        {
            result = charsCommon.getCharsCommonInStrings(charsCommon.testCases[i]);
            System.out.println("###########################################################");
            System.out.println("Input Strings: " + Arrays.toString(charsCommon.testCases[i]));
            System.out.println("No.of characters common in all Strings: " + result);
        }
    }
}
