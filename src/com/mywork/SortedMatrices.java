package com.mywork;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class SortedMatrices
{
    public int[][][][] testCases = {
            { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                    { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } } },
            { { { -1, -2, -3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                    { { 10, 11, 12 }, { -13, -14, -15 }, { 16, 17, 18 } } } };

    public int[] targetSums = { 22, -6 };

    public SortedMatrices()
    {

    }

    /**
     * Function traverses the matrices by lookup in increasing order in matrix 1 with
     * decreasing order in one matrix 2
     * 
     * @param matrices
     * @param sum
     * @return
     */
    private int processMatrices(int[][][] matrices, int sum)
    {
        int c1 = 0, r1 = 0, c2 = matrices[0].length - 1, r2 = matrices[0].length - 1, count = 0;
        int tempsum;
        while (r1 < matrices[0].length && r2 > -1)
        {
            tempsum = matrices[0][r1][c1] + matrices[1][r2][c2];
            if (tempsum == sum)
            {
                System.out.println("Summation possible by: " + matrices[0][r1][c1] + ","
                        + matrices[1][r2][c2]);
                count++;
                c1++;
                c2--;
            }
            else if (tempsum < sum)
            {
                c1++;
            }
            else
            {
                c2--;
            }
            if (c1 == matrices[0].length)
            {
                c1 = 0;
                r1++;
            }
            if (c2 == -1)
            {
                c2 = matrices[0].length - 1;
                r2--;
            }

        }
        return count;
    }

    public static void main(String[] args)
    {
        SortedMatrices sortedMatricesWithSum = new SortedMatrices();

        for (int i = 0; i < sortedMatricesWithSum.testCases.length; i++)
        {
            System.out.println(
                    "#########################################################################");
            int targetSumCount = sortedMatricesWithSum.processMatrices(
                    sortedMatricesWithSum.testCases[i], sortedMatricesWithSum.targetSums[i]);

            System.out.println("Required Sum " + sortedMatricesWithSum.targetSums[i] + " found :"
                    + targetSumCount + " times");
        }

    }

}
