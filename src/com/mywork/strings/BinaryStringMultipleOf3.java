package com.mywork.strings;

/**
 * @author ManiKanta Kandagatla
 */
public class BinaryStringMultipleOf3
{
    /**
     * @param str
     * Follow the DFA for the multiple of String using their remainders
     * @return is Multiple of 3
     */
    public static boolean isMultipleOf3(String str)
    {
        int state = 0;
        char ch;
        for (int i = 0; i < str.length(); i++)
        {
            ch = str.charAt(i);
            switch (state)
            {
                case 0:
                {
                    if (ch == '1')
                    {
                        state = 1;
                    }
                    break;
                }
                case 1:
                {
                    if (ch == '0')
                    {
                        state = 2;
                    }
                    else if (ch == '1')
                    {
                        state = 0;
                    }
                    break;
                }

                case 2:
                {
                    if (ch == '0')
                    {
                        state = 1;
                        break;
                    }
                }
            }
        }
        return state == 0;
    }

    public static void runTestCases()
    {
        String[] binaryStrings = { "1100", "101", "110", "1111", "10101", "1001", "101110",
                "1011101", "10", "0", "1", "10010" };
        for (String binaryString : binaryStrings)
        {
            System.out.println(binaryString + ": " + isMultipleOf3(binaryString));
        }

    }

    public static void main(String[] args)
    {
        runTestCases();
    }

}
