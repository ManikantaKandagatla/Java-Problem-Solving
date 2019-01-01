package com.mywork.hackerrank;

import java.util.Arrays;

/**
 * @author ManiKanta Kandagatla
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class BreakTheRecords
{
    private static int[] breakingRecords(int[] scores)
    {
        int mincount = 0, maxcount = 0;
        int min = scores[0];
        int max = scores[0];
        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] < min)
            {
                mincount++;
                min = scores[i];
            }
            if (scores[i] > max)
            {
                maxcount++;
                max = scores[i];
            }
        }
        return new int[] { maxcount, mincount };
    }

    public static void runTestCases()
    {
        int testCases[][] = { { 12, 24, 10, 24 }, { 10, 5, 20, 20, 4, 5, 225, 1 },
                { 1, 2, 3, 4, 5, 6 }, { 6, 5, 4, 3, 2, 1 } };
        int[] breakCount;
        for (int[] tc : testCases)
        {
            breakCount = breakingRecords(tc);
            System.out.println("Input: "+Arrays.toString(tc) + "\nMax record break: " + breakCount[0]
                    + "\nMin record break: " + breakCount[1] + "\n\n");
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
