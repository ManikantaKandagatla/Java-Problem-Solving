package com.mywork;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ManiKanta Kandagatla
 */
public class DeleteKElements
{
    /**
     * Given a number 'k' Delete first k A[i]s if A[i] < A[i+1] considering the same case after
     * deletion
     * 
     * @param array
     * @param k
     * @return
     */
    public int[] deleteKElements(int[] array, int k)
    {
        int[] result = null;
        int i;
        Stack<Integer> deleteStack = new Stack<Integer>();
        if (array.length > 0)
        {
            deleteStack.push(array[0]);
            for (i = 1; i < array.length; i++)
            {
                int top = deleteStack.peek();
                if (array[i] < top)
                    deleteStack.push(array[i]);
                else
                {
                    while (top < array[i] && k != 0)
                    {
                        k--;
                        deleteStack.pop();
                        if (deleteStack.isEmpty())
                            break;
                        top = deleteStack.peek();
                    }
                    deleteStack.push(array[i]);
                }
            }
            k = deleteStack.size() - 1;
            result = new int[k + 1];
            while (k >= 0)
            {
                result[k] = deleteStack.pop();
                k--;
            }
        }
        return result;
    }

    public void testDeleteKElements()
    {
        int[][] testCases = { { 1, 2, 3, 4, 5, 6 }, { 10, 11, 19, 0, 8, -1 }, { 3, 100, 1 },
                { 20, 10, 25, 30, 40 }, { 23, 45, 11, 77, 18 }, {}, { 1 } };
        int[] testKs = { 1, 4, 1, 2, 3, 10, 3 };
        for (int i = 0; i < testCases.length; i++)
        {
            System.out.println("##################################################");
            System.out.println("Input: " + Arrays.toString(testCases[i]) + ",  k: " + testKs[i]);
            System.out.println(
                    "Output: " + Arrays.toString(deleteKElements(testCases[i], testKs[i])));
        }
    }

    public static void main(String[] args)
    {
        DeleteKElements testObj = new DeleteKElements();
        testObj.testDeleteKElements();
    }
}
