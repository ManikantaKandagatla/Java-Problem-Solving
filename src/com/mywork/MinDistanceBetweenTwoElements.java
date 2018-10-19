package com.mywork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manikanta Kandagatla
 */
public class MinDistanceBetweenTwoElements
{

    public int getMinimumDistance(int[] arr, int[] mn)
    {
        int m = mn[0], n = mn[1], i = 0, j = 0;;
        int minDiff = Integer.MAX_VALUE, diff;
        List<Integer> mIndexes = new ArrayList<Integer>();
        List<Integer> nIndexes = new ArrayList<Integer>();
        for (i = 0; i < arr.length; i++)
        {
            if (arr[i] == m)
                mIndexes.add(i);
            else if (arr[i] == n)
                nIndexes.add(i);
        }
        i = 0;
        //System.out.println("m Indexes : "+ mIndexes);
        //System.out.println("n Indexes : "+ nIndexes);
        while ((i < mIndexes.size()) && (j < nIndexes.size()))
        {
            int mIndex = mIndexes.get(i);
            int nIndex = nIndexes.get(j);
            if ( mIndex < nIndex)
            {
                diff = Math.abs(mIndex - nIndex);
                if (diff < minDiff)
                    minDiff = diff;
                i++;
            }
            else
            {
                diff = Math.abs(mIndex - nIndex);
                if (diff < minDiff)
                    minDiff = diff;
                j++;
            }
        }
        return minDiff-1;

    }

    public void runTestCases()
    {
        int[] arr = { 1, 1, 2, 3, 4, 45, 4, 7, 4, 7, 1, 7, 34, 3, 19,55 };
        int[][] tcs = { { 1, 19 }, { 2, 19 }, { 2, 4 }, { 3, 34 } };
        System.out.println("Input array: " + Arrays.toString(arr));
        for (int i = 0; i < tcs.length; i++)
        {
            System.out.println("Min distance between " + tcs[i][0] + ", " + tcs[i][1] + ": "
                    + getMinimumDistance(arr, tcs[i]));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        MinDistanceBetweenTwoElements testObj = new MinDistanceBetweenTwoElements();
        testObj.runTestCases();

    }
}
