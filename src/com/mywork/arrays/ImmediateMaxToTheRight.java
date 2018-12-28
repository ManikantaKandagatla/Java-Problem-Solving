package com.mywork.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ManiKanta Kandagatla
 */
public class ImmediateMaxToTheRight
{

    /**
     * Given an array. Prints the immediate max to the right of array[i] element
     * 
     * @param array
     */
    public void printImmediateMaxToTheRight(int[] array)
    {
        Stack<Integer> immediateMaxes = new Stack<Integer>();
        immediateMaxes.push(array[0]);
        for (int i = 1; i <  array.length ; i++)
        {
            if(!immediateMaxes.isEmpty())
            {
                int stackTop = immediateMaxes.peek();
                immediateMaxes.pop();
                
                while(stackTop < array[i])
                {
                    System.out.println("Next Greater Element to "+ stackTop + ": "+array[i]);
                    if(immediateMaxes.isEmpty())
                        break;
                    stackTop = immediateMaxes.peek();
                    immediateMaxes.pop();
                }
                if(array[i] < stackTop)
                {
                   immediateMaxes.push(stackTop);
                }
            }
            immediateMaxes.push(array[i]);
        }
        while(!immediateMaxes.isEmpty())
        {
            System.out.println("Next Greater Element to "+ immediateMaxes.peek() + ": -1");
            immediateMaxes.pop();
        }
    }
    
    /**
     * Driver function to execute possible test cases 
     */
    public void testPrintImmediateMaxToTheRight()
    {
        int[][] testCases = { { 1, 2, 3, 4, 5, 6, 7 },
                { 11, 45, 23, 35, 37, -1, 66, 12, 34, 56, 7, 6, 710, 16 },
                {1,3,-1,2,10,7,6,5,4,8,3,2,110,16,0}};
        for (int[] testCase : testCases)
        {
            System.out.println("######################################");
            System.out.println("Input: " + Arrays.toString(testCase));
            printImmediateMaxToTheRight(testCase);
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ImmediateMaxToTheRight testObj = new ImmediateMaxToTheRight();
        testObj.testPrintImmediateMaxToTheRight();
    }

}
