package com.mywork.arrays;

/**
 * @author Manikanta Kandagatla
 */
public class NumberLessThanANumberWithoutDigits
{

    public String getNumberLessThanNWithoutDigits(int n)
    {
        String numberStr = "" + n;
        int i, j, desiredLength = numberStr.length(), startDigit;
        boolean[] digits = new boolean[10];
        for (i = 0; i < numberStr.length(); i++)
        {
            char ch = numberStr.charAt(i);
            digits[ch - '0'] = true;
        }
        int firstDigit = numberStr.charAt(0) - '0';
        if (firstDigit == 1)
        {
            desiredLength = numberStr.length() - 1;
            startDigit = 9;
            while(digits[startDigit])
            {
                startDigit--;
            }
        }
        else
        {
            startDigit = firstDigit - 1;
        }
        for (i = 9; i >= 0; i--)
        {
            if (digits[i] == false)
            {
                break;
            }
        }
        String numberLessThan = "" + startDigit;
        for (j = 0; j < desiredLength - 1; j++)
        {
            numberLessThan += i;
        }
        return numberLessThan;
    }

    public void runTestCases()
    {
        int tcs[] = { 968, 100, 123, 439, 1010, 1019, 19678 };
        for (int i = 0; i < tcs.length; i++)
        {
            System.out.println("Number less than " + tcs[i] + " without the digits: "
                    + getNumberLessThanNWithoutDigits(tcs[i]));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        NumberLessThanANumberWithoutDigits testObj = new NumberLessThanANumberWithoutDigits();
        testObj.runTestCases();
    }

}
