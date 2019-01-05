package com.mywork.strings;

/**
 * @author ManiKanta Kandagatla
 */
public class Subsequence
{
    /**
     * @param a
     * @param b
     * @return true if String "b" is a sub sequence of String "a
     */
    public static boolean isSubSequence(String a, String b)
    {
        int j = 0;
        if (b == null || b == "")
        {
            return false;
        }
        else
        {
            for (int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) == b.charAt(j))
                {
                    j++;
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
                { "bhimavaramcity", "bhimavaram", "bmava", "bmmm", "aaa", "mm", "bmvacy", "by",
                        "mmciy", "abcd", "", "vacity", "mvramct","mvvvramct" },
                { "manikanta", "mnknt", "mnnta", "int", "aaaa" }, { "hyderabad", "yrbd" } };
        for (String[] tc : testCases)
        {
            String sourceString = tc[0];
            System.out.println("####################################################");
            System.out.println("Source String: " + sourceString);
            for (int i = 1; i < tc.length; i++)
            {
                System.out.println(tc[i] + ": " + isSubSequence(sourceString, tc[i]));
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
