/*
 * Copyright (C) 2017 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mywork.arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author mk186084
 * @version $Id: $
 */
public class RunningMedian
{

    /**
     * 
     */
    public RunningMedian()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int length;
        TreeSet sorted = new TreeSet<Integer>();
        Scanner in = new Scanner(System.in);
        length = in.nextInt();
        while(length-- > 0)
        {
            int element=in.nextInt();
            sorted.add(element);
        }
        

    }

}
