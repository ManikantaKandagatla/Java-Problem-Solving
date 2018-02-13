package com.mywork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class FormMaxNumber
{
    public String[][] testCases = { { "1234", "123", "1234", "5" },
            { "986", "9", "978", "98", "5000", "70", "986" }, { "", "12", "1" },
            { "9878", "98", "98986", "67", "678", "34", "345" } };

    /**
     * Function returns max number formed by arranging array of numbers lexographically decreasing
     * 
     * @param numbers
     * @return
     */
    public String prepareMaxNumber(String[] numbers)
    {
        String maxNumber = "";
        Comparator<String> numberComparator = new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                return s2.concat(s1).compareTo(s1.concat(s2)) > 0 ? 1 : -1;
            }
        };

        TreeSet<String> lexographicDecreasingNumbers = new TreeSet<String>(numberComparator);
        for (String number : numbers)
        {
            lexographicDecreasingNumbers.add(number);
        }
        for (String number : lexographicDecreasingNumbers)
        {
            maxNumber = maxNumber.concat(number);
        }
        return maxNumber;
    }

    public static void main(String[] args)
    {
        FormMaxNumber formMaxNumberObj = new FormMaxNumber();
        for (int i = 0; i < formMaxNumberObj.testCases.length; i++)
        {
            System.out.println("################################################");
            System.out.println("Input : " + Arrays.toString(formMaxNumberObj.testCases[i]));
            System.out.println("Max number formed: "
                    + formMaxNumberObj.prepareMaxNumber(formMaxNumberObj.testCases[i]) + "\n");
        }
    }

}
