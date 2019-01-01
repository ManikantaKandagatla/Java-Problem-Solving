package com.mywork.hackerrank;

/**
 * @author ManiKanta Kandagatla
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum
{
    private static int superDigit(String n, int k)
    {
        n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
        return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));
    }

    public static void runTestCases()
    {
        String[] numbers = { "123", "123", "9876" };
        int[] repeatCount = { 3, 4, 5 };
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println("Input: " + numbers[i] + " k: " + repeatCount[i] + "\nSuper Digit: "
                    + superDigit(numbers[i], repeatCount[i])+"\n\n");
        }
    }

    public static void main(String args[])
    {
        runTestCases();
    }
}
