package com.mywork;

public class MaxConsecutiveOnes
{
    /**
     * Given a number, returns binary number in reverse manner
     * 
     * @param n
     * @return
     */
    public String toBinary(int n)
    {
        String binary = "";
        while (n != 0)
        {
            binary += n % 2;
            n = n / 2;
        }
        return binary;
    }

    /**
     * Given a number, Prints the maximum consecutive 1's in its binary number format
     * 
     * @param n
     * @return
     */
    public int printMaxConsecutiveOnes(int n)
    {
        String binaryString = toBinary(n);
        int currentMax = 0, max = 0;
        for (int i = 0; i < binaryString.length(); i++)
        {
            char c = binaryString.charAt(i);
            if (c == '0')
            {
                if (currentMax > max)
                    max = currentMax;
                currentMax = 0;
            }
            else
                currentMax++;
        }
        return currentMax > max ? currentMax : max;
    }

    public void testPrintMaxConsecutiveOnes()
    {
        int[] testCases = { 12, 3, 1, 10, 8, 32, 31, 45 };
        for (int i = 0; i < testCases.length; i++)
        {
            System.out
                    .println("##################################################################");
            System.out.println("Input : " + testCases[i]);
            System.out.println("Max consecutive 1's in binary String for " + testCases[i] + " :"
                    + printMaxConsecutiveOnes(testCases[i]));
        }
    }

    public static void main(String[] args)
    {
        MaxConsecutiveOnes testObj = new MaxConsecutiveOnes();
        testObj.testPrintMaxConsecutiveOnes();
    }
}