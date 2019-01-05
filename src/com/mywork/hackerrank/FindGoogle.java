package com.mywork.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ManiKanta Kandagatla
 *         https://www.hackerrank.com/contests/find-google/challenges/find-google/problem
 */
public class FindGoogle
{

    public static Map<String, String> getCharEquivalents()
    {
        Map<String, String> charMap = new HashMap<String, String>();
        charMap.put("()", "o");
        charMap.put("[]", "o");
        charMap.put("<>", "o");
        charMap.put("0", "o");
        charMap.put("o", "o");
        charMap.put("g", "g");
        charMap.put("l", "l");
        charMap.put("e", "e");
        charMap.put("3", "e");
        charMap.put("I", "l");
        charMap.put("|", "l");
        charMap.put("(", "(");
        charMap.put("<", "<");
        charMap.put("[", "[");
        charMap.put("O", "o");
        charMap.put("G", "g");
        charMap.put("L", "l");
        charMap.put("E", "e");
        return charMap;
    }

    public static boolean isGoogle(String string)
    {
        char ch1;
        int i;
        Map<String, String> charMap = getCharEquivalents();
        String converted = "";
        boolean result = true;
        String temp;
        for (i = 0; i < string.length(); i++)
        {
            ch1 = string.charAt(i);
            if ((ch1 >= 'a' && ch1 <= 'z') || ch1 == '3' || ch1 == '0'
                    || (ch1 >= 'A' && ch1 <= 'Z'))
            {
                temp = charMap.get("" + ch1);
                // System.out.println("temp: "+temp );
                if (temp == null)
                {
                    result = false;
                    break;
                }
                else
                {
                    converted = converted + temp;
                }

            }
            else if (charMap.containsKey("" + ch1) && i < string.length() - 1)
            {
                temp = charMap.get("" + ch1 + string.charAt(i + 1));
                // System.out.println("temp: "+temp );
                i = i + 1;
                if (temp == null)
                {
                    result = false;
                    break;
                }
                else
                {
                    converted = converted + temp;
                }
            }
            else if (ch1 == ' ')
            {
                result = false;
                break;
            }
        }
        // System.out.println(converted + result);
        if (!result || !("google".equals(converted)))
        {
            return false;
        }
        else
            return true;
    }

    public static void runTestCases()
    {
        String[] googleStrings = { "google", "GOOGLE", "G<><>gL3", "G[]<>GLE", "g<>()gIe", "g00gle",
                "g0oGle", "g<>0gl3", "googl3", "GooGIe", "   g o o g le", "  google", "GooGie" };
        for (String string : googleStrings)
        {
            System.out.println(string + ": " + isGoogle(string));
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        runTestCases();

    }

}
