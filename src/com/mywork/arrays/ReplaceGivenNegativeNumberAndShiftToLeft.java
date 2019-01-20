package com.mywork.arrays;

import java.util.Arrays;

/**
 * @author ManiKanta Kandagatla 
 * Replace an element X in an array of non negative integers with 1 and
 *         move all the replaced 1s to left of array without changing order of other elements.
 */
public class ReplaceGivenNegativeNumberAndShiftToLeft
{
    /**
     * Assuming target = -1 to make the input simple
     * 
     * @param arr
     * @param target
     */
    public static int[] replaceAndShift(int[] arr, int target)
    {
        if (arr == null || arr.length == 0)
            return arr;
        else
        {
            int count = 0;
            int[] op = new int[arr.length];
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] == target)
                    count++;
            }
            for (int i = 0; i < count; i++)
                op[i] = 1;
            for (int i = 0, j = count; i < arr.length; i++)
            {
                if (arr[i] != target)
                    op[j++] = arr[i];
            }
            return op;
        }
    }

    public static void runTestCases()
    {
        int[][] testCases = { { -1, -2, -1, -1, -3, -1, -1, -96 }, { -1, -1, -1, -1 },
                { -2, -3, -5, -6, -56, -1, -1, -1 }, { -1, -2, -1, -3, -1, -1, -4, -1, -5 }, {},
                null };
        for (int[] tc : testCases)
        {
            System.out.println("Input: " + Arrays.toString(tc));
            System.out.println("Resultant Array after replace and shift of (-1) to (1): "
                    + Arrays.toString(replaceAndShift(tc, -1)) + "\n\n");
        }
    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
