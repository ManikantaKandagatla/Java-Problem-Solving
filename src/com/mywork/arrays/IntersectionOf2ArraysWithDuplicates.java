package com.mywork.arrays;

import java.util.*;

public class IntersectionOf2ArraysWithDuplicates {

    private static void printIntersectionOfArrays(Integer[] a, Integer[] b) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        if (a != null && b != null && a.length > 0 && b.length > 0) {
            for (int i = 0; i < b.length; i++) {
                if (!countMap.containsKey(b[i])) {
                    countMap.put(b[i], 1);
                } else {
                    countMap.put(b[1], countMap.get(b[i]) + 1);
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (countMap.containsKey(a[i])) {
                    int count = countMap.get(a[i]);
                    if (count > 0) {
                        countMap.put(a[i], count - 1);
                        intersection.add(a[i]);
                    }

                }
            }
        }
        System.out.println("Intersection elements: " + intersection);
    }

    public static void runTestCases() {
        Integer[][][] testCases = {{{1, 2, 3, 4, 2, 5},{1, 2, 2, 3, 4, 5}},
                {{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}}};
        for (Integer[][] tc : testCases) {
            printIntersectionOfArrays(tc[0], tc[1]);
        }
    }

    public static void main(String args[]) {
        runTestCases();
    }
}
