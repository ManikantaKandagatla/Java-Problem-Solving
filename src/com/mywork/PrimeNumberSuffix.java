package com.mywork;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class PrimeNumberSuffix
{

    private Scanner in;

    /**
     * 
     */
    public PrimeNumberSuffix()
    {
        in = new Scanner(System.in);
    }

    public void Print(String s)
    {
        System.out.println(s);
    }

    public long getSuffix(String[] tokens)
    {
        long number, max2Prime = Long.MIN_VALUE, max1Prime= Long.MIN_VALUE;
        long primeCount = 0;
        for (int index = 0; index < tokens.length; index++)
        {
            if (index == tokens.length - 1)
            {
                number = Long.parseLong(tokens[index].substring(0, tokens[index].length() - 1));
            }
            else
                number = Long.parseLong(tokens[index]);
            if(isPrime(number))
            {
                if( number > max1Prime)
                {
                    max2Prime = max1Prime;
                    max1Prime = number;
                }
                else if(number > max2Prime)
                    max2Prime = number;
                primeCount++;
                //Print(""+number);
            }
        }
        return primeCount >= 2 ? primeCount+ max2Prime : -1;
    }
    
    public boolean isPrime(long number)
    {
        Long[] basicPrimes = {2L,3L,5L,7L,11L};
        List<Long> primes = Arrays.asList(basicPrimes);
        if(primes.contains(number) || (!isPerfectSquare(number) && (number % 6 == 1 || number% 6 == 5)))
            return true;
        return false;
        
    }
    
    public boolean isPerfectSquare(long number)
    {
        long SquareRoot = (long) Math.sqrt(number);
        return ((SquareRoot * SquareRoot) == number);
    }
    
    public void getInput()
    {
        String inputString;
        inputString = in.nextLine();
        Print(""+getSuffix(inputString.split(" ")));
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        PrimeNumberSuffix psuffix = new PrimeNumberSuffix();
        psuffix.getInput();
    }

}
