/*
 * Copyright (C) 2017 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mywork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mk186084
 * @version $Id: $
 */
public class ArrayRotation
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int d=2,n =7;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<8;i++)
            list.add(i);
        for (int ele: list)
        {
            System.out.print(ele);
        }
        System.out.println("\n");
        List<Integer> list1 = list.subList(d,7);
        list.addAll(list1);
        list.addAll(list.subList(0, d));
        list.removeAll(list.subList(0, n));
        for (int ele: list)
        {
            System.out.print(ele);
        }
        System.out.println();
        Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
        
        Collections.sort(list, new Comparator<Integer>()
                {
            @Override
            public int compare(Integer X, Integer Y) {
             
            // first append Y at the end of X
            
             
            // Now see which of the two formed numbers 
            // is greater
            return X> Y ? X:Y;
            }});
        char arr[] = {'a','b','c'};
        System.out.println(arr[0]-'a');
        
    }
    
    

}
