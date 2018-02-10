package com.mywork;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

/**
 * A String is said to magic string if it contains all the english alphabets-case insensitive
 */
public class MagicString
{
    public String[] testCases = { "abcdefghijklmnopqrstuz ",
            "AbcDEFGhiJklMno .< !@#$%^&*()-=+`~{ } []|;:',.><' \" pqrstuvwxyz",
            "Pack my bx with five dozen liqour jugs", "I am from Bhimavaram",
            "ABCDEF GHIJK LM NO PQRSTUV", "12 34 DFDF 875T : LFDSFW3#", "" };

    /**
     * Function returns characters required for input string to become a magic string
     * 
     * @param
     * @return
     */
    public String missingCharsForMagicString(String s)
    {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            {
                if (ch >= 'A' && ch <= 'Z')
                    ch = (char) (ch + 32);
                alphabets = alphabets.replace("" + ch, "");
            }
        }
        return alphabets;
    }

    /**
     * Function returns characters required for input string to become a magic string
     * 
     * @param s
     * @return
     */
    public String missingCharsForMagicString_Approach2(String s)
    {
        String missingCharacters = "";
        boolean[] alphabetsPresent = new boolean[26];
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            {
                if (ch >= 'A' && ch <= 'Z')
                    ch = (char) (ch + 32);
                alphabetsPresent[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++)
        {
            if (!alphabetsPresent[i])
            {
                missingCharacters += "" + (char) ('a' + i);
            }
        }
        return missingCharacters;
    }

    public static void main(String[] args)
    {
        MagicString magicString = new MagicString();
        for (int i = 0; i < magicString.testCases.length; i++)
        {
            System.out.println("#####################################################");
            System.out.println("Input String: " + magicString.testCases[i]);
            System.out.println("Characters required to make string magic - Approach 1: "
                    + magicString.missingCharsForMagicString(magicString.testCases[i]) + "\n");
            System.out.println("Characters required to make string magic - Approach 2: "
                    + magicString.missingCharsForMagicString_Approach2(magicString.testCases[i])
                    + "\n");
        }
    }

}
