/*
 * Copyright (C) 2018 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mywork;

/**
 * @author Manikanta Kandagatla
 * @version $Id: $
 */
public class PowerOfTwo
{

    /**
     * 
     */
    public PowerOfTwo()
    {
        // TODO Auto-generated constructor stub
    }

    public boolean isPowerOftwo(int num)
    {
        return ((num - 1) & num) == 0 ? true : false;
    }

    public void runTestCases()
    {
        int[] tc = { 1, 2, 3, 4, 15, 16, 31, 40, 64 };
        for(int  i=0; i < tc.length ;i++)
        {
            System.out.println(tc[i] + ": " + isPowerOftwo(tc[i]));
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        PowerOfTwo testObj = new PowerOfTwo();
        testObj.runTestCases();
    }

}
