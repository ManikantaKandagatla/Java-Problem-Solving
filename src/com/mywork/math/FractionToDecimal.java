package com.mywork.math;

public class FractionToDecimal {
    private static String printFractionToDecimal(int a, int b, int decimalPlaces) {
        StringBuilder result = new StringBuilder();
        if(a % b == 0)
            return result.append(a / b).toString();
        else {
            int i = 0;
            result.append(a/ b);
            result.append(".");
            while( i < decimalPlaces) {
                int rem = a % b;
                result.append((rem *10) / b );
                a = rem * 10 % b;
                i++;
            }
            return result.toString();
        }
    }

    public static void runTestCases() {
        Integer[][] testCases = {{1, 2}, {10, 15}, {13, 5}, {16, 4}, {2, 3}, {1, 7}};
        for (Integer[] tc : testCases) {
            System.out.println(tc[0] + "/" + tc[1] + ": " + printFractionToDecimal(tc[0], tc[1], 5));
        }
    }

    public static void main(String args[]) {
        runTestCases();
    }
}
