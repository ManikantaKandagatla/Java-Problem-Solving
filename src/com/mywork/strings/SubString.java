package com.mywork.strings;

/**
 * @author ManiKanta Kandagatla
 */
public class SubString
{

    /**
     * @param a
     * @param b
     * @return true if String "b" is a substring of String "a
     */
    public static boolean isSubString(String a, String b)
    {
        int j = 0;
        if (b == null || a.length() < b.length())
        {
            return false;
        }
        else if (b == "")
        {
            return true;
        }
        else
        {
            for (int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) == b.charAt(j))
                {
                    j++;
                }
                else
                {
                    j = 0;
                }
                if (j == b.length())
                {
                    break;
                }
            }
            if (j == b.length())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static void runTestCases()
    {
        String[][] testCases = {
                { "bhimavaramcity", "bhimavaram", "bhimava", "vara", "mava", "mcity", "bmvacy",
                        "by", "him", "abcd", "", "city", "varam", "ram", "erbhimavaramcitydfsdf" },
                { "manikanta", "kanta", "mani", "man", "a", "ikan" },
                { "hyderabad", "bad", "hyder", "rabad", "ydera", "badd", "ahcdhyderabad" } };
        for (String[] tc : testCases)
        {
            String sourceString = tc[0];
            System.out.println("####################################################");
            System.out.println("Source String: " + sourceString);
            for (int i = 1; i < tc.length; i++)
            {
                System.out.println(tc[i] + ": " + isSubString(sourceString, tc[i]));
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
