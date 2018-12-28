package com.mywork.strings;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class StringReverseUsingRecursion
{

    public static String strRev(String str, int start, int end)
    {
        if (str == null || str == "")
        {
            return str;
        }
        else
        {
            if (start == end - 1)
            {
                return str;
            }
            else
            {
                return strRev(str.substring(1, str.length()), start + 1, end) + str.charAt(0);
            }
        }
    }

    public static void runTestCases()
    {
        String[] Strings = { "manikanta", "madam", "haii", "Bhimavaram", "a", "","Hyderabad" };
        for (String str : Strings)
        {
            System.out.println("Input: " + str + "\nOutput: " + strRev(str, 0, str.length()));
        }

    }

    public static void main(String[] args)
    {
        runTestCases();
    }
}
