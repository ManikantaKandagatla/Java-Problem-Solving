package com.mywork.arrays;

import java.util.*;

public class LuckyNumbers {
    public static int findLucky(int[] arr) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0 ;i < arr.length; i++) {
            if(countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i])+1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        Set<Integer> luckyNums = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });
        for(int i=0; i < arr.length; i++) {
            if(countMap.get(arr[i]) == arr[i]) {
                luckyNums.add(arr[i]);
            }
        }
        List<Integer> list = new ArrayList<>(luckyNums);
        return luckyNums.size()==0 ? -1 : list.get(0);
    }

    public static void runTestCases() {
        int[][] testCases = { {2,2,3,1} , {2,2,2,3,3,3,1}, {2,3,4}};
        for(int[] tc: testCases) {
            System.out.println(Arrays.toString(tc) + "\nLucky number: "+findLucky(tc));
        }
    }
    public static void main(String args[]) {
        runTestCases();
    }
}
