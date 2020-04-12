package com.mywork.math;

public class ProperFraction {

    private static void printProperFraction(int numerator, int denominator) {
        int hcf = gcd(numerator, denominator);
        numerator = numerator / hcf;
        denominator = denominator / hcf;
        System.out.println("Reduced fraction: " + numerator + "/" + denominator + "\n\n");

    }

    private static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public static void runTestCases() {
        Integer[][] testCases = {{1, 2}, {10, 15}, {13, 5}, {16, 4}};
        for (Integer[] tc : testCases) {
            System.out.println("Fraction: " + tc[0] + "/" + tc[1]);
            printProperFraction(tc[0], tc[1]);
        }
    }

    public static void main(String args[]) {
        runTestCases();
    }
}
