package com.mywork.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ManiKanta Kandagatla
 */
public class LongestCommonSubstring
{
    public static List<String> getStringsFromIndex(int[][] dp, List<Integer> indexStore, String b)
    {
        if (indexStore.isEmpty())
        {
            return new ArrayList<String>();
        }
        else
        {
            List<String> lcSubString = new ArrayList<String>();
            int i, j;
            String subStr;
            for (int k = 0; k < indexStore.size(); k += 2)
            {
                i = indexStore.get(k);
                j = indexStore.get(k + 1);
                //System.out.println(dp[i][j]+ " , "+ j +", "+ b);
                subStr = b.substring(j - dp[i][j]+1, j+1);
                lcSubString.add(subStr);
            }
            return lcSubString;
        }
    }

    /**
     * 
     * @param a
     * @param b
     * @return List of longest common substring(s) in String a and String b
     */
    public static List<String> getLongestCommonSubString(String a, String b)
    {

        List<Integer> indexStore = new ArrayList<>();
        int m = a.length(), n = b.length(), maxLength = 0, i, j;
        int[][] dp = new int[m][n];
        for (i = 0; i < m; i++)
        {
            for (j = 0; j < n; j++)
            {

                if (a.charAt(i) == b.charAt(j))
                {
                    dp[i][j] = (i - 1) >= 0 && (j -1 ) >= 0? dp[i - 1][j - 1] + 1 : 1;
                    if (dp[i][j] > maxLength)
                    {
                        maxLength = dp[i][j];
                        indexStore.clear();
                        indexStore.add(i);
                        indexStore.add(j);
                    }
                    else if (dp[i][j] == maxLength)
                    {
                        indexStore.add(i);
                        indexStore.add(j);
                    }
                }
                else
                    dp[i][j] = 0;

            }
        }
        return getStringsFromIndex(dp, indexStore, b);
    }

    public static void runTestCases()
    {
        String[][] testCases = { { "manikanta", "Iammanikatna" }, { "hyderabad", "goodbadway" },
                { "manikanta", "manikanta" }, { "bhimavaram", "varahamitra" },
                { "bhimavaram town", "i am from bhimavaram city" },
                { "hackerrank", "hackerackerrerrank" } };
        for (String[] tc : testCases)
        {
            System.out.println("###############################################");
            System.out.println("s1 : " + tc[0]);
            System.out.println("s2 : " + tc[1]);
            System.out.println("Longest Common Sub-String(s): "
                    + getLongestCommonSubString(tc[0], tc[1]) + "\n\n");
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
