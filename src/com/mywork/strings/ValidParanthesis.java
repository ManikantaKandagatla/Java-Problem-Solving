package com.mywork.strings;

import com.mywork.trees.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    private static final Map<Character, Character> bracesMap = new HashMap<>();


    private static boolean isValidParanthesis(String expression) {
        Stack<Character> st = new Stack<>();
        char ch2;
        for(char ch1 : expression.toCharArray()) {
            if(bracesMap.containsKey(ch1)) {
                if(st.isEmpty() || bracesMap.get(ch1) != st.pop()) {
                    return false;
                }
            } else {
                st.add(ch1);
            }
        }
        return true && st.isEmpty();
    }

    public static void runTestCases() {
        int i, j;
        String[] testCases = {"([)]", "(]",  "()[]{}", "()", "[[[]]", "]]"};
        for (i = 0; i < testCases.length; i++) {
            System.out.println(testCases[i] +": " + isValidParanthesis(testCases[i]));
        }
    }

    static {
        bracesMap.put(')', '(');
        bracesMap.put(']', '[');
        bracesMap.put('}', '{');
    }

    public static void main(String args[]) {
        runTestCases();
    }
}
