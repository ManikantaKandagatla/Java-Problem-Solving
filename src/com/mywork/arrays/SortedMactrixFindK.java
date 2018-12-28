package com.mywork.arrays;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class SortedMactrixFindK
{
    public int[][][] testCases = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
            { { 1, 2 }, { 2, 3 } }, { { 1 } }, { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
            { { 1 }, { 2 }, { 3 } }, { { 1, 2, 3 } },{{}} };

    public int[] testKeys = { 5, 3, 1, 10, 3, 1, -1 };

    /**
     * Finds an element is present in sorted matrix rowwise and columnwise. Time complexity- m+n
     * 
     * @param matrix
     * @param key
     * @return
     */
    public boolean findKey(int[][] matrix, int key)
    {
        int i = 0, j = matrix[0].length - 1;
        boolean found = false;
        while (i < matrix.length && j >= 0)
        {
            if (matrix[i][j] == key)
            {
                found = true;
                break;
            }
            if (matrix[i][j] > key)
                j--;
            else
                i++;
        }
        return found;
    }

    public static void main(String[] args)
    {
        SortedMactrixFindK findObj = new SortedMactrixFindK();
        for (int i = 0; i < findObj.testCases.length; i++)
        {
            System.out.println("#######################################################");
            System.out.println("Key  : " + findObj.testKeys[i]);
            System.out.println(
                    "Found: " + findObj.findKey(findObj.testCases[i], findObj.testKeys[i]) + "\n");
        }
    }

}
