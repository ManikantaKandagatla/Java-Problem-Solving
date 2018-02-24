package com.mywork;

import java.util.Arrays;

/**
 * @author ManiKanta Kandagatla
 */
public class MaxElementToTheRight
{
    /**
     * Given an array, prints the max element in the right of ith index for each array[i] element
     * 
     * @param array
     */
    public void printMaxTotheRight(int[] array)
    {
        int[] rightMaxes = new int[array.length+1];
        rightMaxes[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2 ; i >= 0; i--)
        {
            if(array[i] >= rightMaxes[i+1])
            {
                rightMaxes[i] = array[i];
            }
            else rightMaxes[i] = rightMaxes[i+1];
        }
        rightMaxes[array.length]=-1;
        System.out.print("Output: [");
        for(int i =1; i < rightMaxes.length-1;i++)
        {
            System.out.print(rightMaxes[i]+", ");
        }
        System.out.println(" ]");

    }

    /**
     * 
     */
    public void testPrintMaxTotheRight()
    {
        int[][] testCases = { { 1, 2, 3, 4, 5, 6, 7 }, { 7, 6, 5, 4, 3, 2, 1 },
                { 1, 55, 3, 8, 19, 0, -1, 52, 16, 98, 12, 7, 43, 22 },
                {100,101,102,103,50,51,52,53,45,46,49,42,15,12}};
        for (int[] testCase : testCases)
        {
            System.out.println("######################################################");
            System.out.println("Input : "+ Arrays.toString(testCase));
            printMaxTotheRight(testCase);
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        MaxElementToTheRight testObj = new MaxElementToTheRight();
        testObj.testPrintMaxTotheRight();
    }
}
