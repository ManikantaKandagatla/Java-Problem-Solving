package com.mywork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class ExpressionEvaluation
{
    public HashMap<String, Integer> operatorPrecedence;

    public Stack<String> operatorsStack;

    public Stack<Double> evaluationStack;

    public String[] testCases = { "2", "(2)+(49)", "36*7+127/2*7+5^2-29", "(3*7)^4/(3+(2*2))",
            "22/4+335/(2^3*(4+5-(22/4))*3)", "((2+4-89+22)-(13*6-34)/2*2^3)",
            "1/26^2*104",""};

    /**
     * 
     */
    public ExpressionEvaluation()
    {
        operatorPrecedence = new HashMap<String, Integer>();
        operatorsStack = new Stack<String>();
        evaluationStack = new Stack<Double>();
        operatorPrecedence.put("+", 1);
        operatorPrecedence.put("-", 1);
        operatorPrecedence.put("*", 2);
        operatorPrecedence.put("/", 2);
        operatorPrecedence.put("^", 3);
        operatorPrecedence.put("(", 4);
        operatorPrecedence.put(")", 4);

    }

    public void Print(String s)
    {
        System.out.println(s);

    }

    public String[] getExpressionTokens(String expression)
    {
        String[] expressionTokens = expression
                .split("(?<=[-+*/\\(\\)])|(?=[-+*/\\(\\)])|(?<=[\\^])|(?=[\\^])");
        return expressionTokens;
    }

    /**
     * Function converts an infix expression to postfix expression
     * 
     * @param expression
     * @return - postfix expression as a list of tokens
     */
    public List<String> infixToPotfix(String expression)
    {
        int index;
        String[] expressionTokens = getExpressionTokens(expression);
        List<String> postfixExpression = new ArrayList<String>();
        for (index = 0; index < expressionTokens.length; index++)
        {
            if (operatorPrecedence.get(expressionTokens[index]) != null)
            {
                if (operatorsStack.isEmpty())
                    operatorsStack.push(expressionTokens[index]);
                else
                {
                    if (expressionTokens[index].equals(")"))
                    {
                        while (!operatorsStack.peek().equals("("))
                        {
                            postfixExpression.add(operatorsStack.pop());
                        }
                        operatorsStack.pop();
                    }
                    else
                    {
                        while (true && !operatorsStack.isEmpty())
                        {
                            String top = operatorsStack.peek();
                            if (!top.equals("(") && (operatorPrecedence
                                    .get(top) >= operatorPrecedence.get(expressionTokens[index])))
                            {
                                postfixExpression.add(operatorsStack.pop());
                            }
                            else
                            {
                                break;
                            }
                        }
                        operatorsStack.push(expressionTokens[index]);
                    }

                }
            }
            else
            {
                if (!expressionTokens[index].equals(""))
                    postfixExpression.add(expressionTokens[index]);
            }
        }
        while (true && !operatorsStack.isEmpty())
            postfixExpression.add(operatorsStack.pop());
        return postfixExpression;
    }

    /**
     * Evaluates a postfix expression
     * 
     * @param postFixExpression
     * @return- value of expression
     */
    private double postfixEvaluation(List<String> postFixExpression)
    {
        for (String token : postFixExpression)
        {
            if (operatorPrecedence.get(token) != null)
            {
                double op1 = evaluationStack.pop();
                double op2 = evaluationStack.pop();
                evaluationStack.push(expressionEvaluate(op1, op2, token));
            }
            else
                evaluationStack.push(Double.parseDouble(token));
        }
        return evaluationStack.isEmpty()?0:evaluationStack.pop();
    }

    /**
     * Evaluates operation depending on operator specified
     * 
     * @param operand1
     * @param operand2
     * @param token
     * @return
     */
    private double expressionEvaluate(double operand1, double operand2, String token)
    {
        double result = 0;
        switch (token)
        {
            case "+":
                result = operand2 + operand1;
                break;
            case "-":
                result = operand2 - operand1;
                break;
            case "*":
                result = operand2 * operand1;
                break;
            case "/":
                result = operand2 / operand1;
                break;
            case "^":
                result = Math.pow(operand2, operand1);
                break;
            default:
        }
        // Print(""+result);
        return result;
    }

    private void run()
    {
        //String expression = in.nextLine();
        for (String expression: testCases )
        {
            List<String> postFixExpression = infixToPotfix(expression);
            Print("#############################################################");
            Print("Expression: "+expression);
            Print("Postfix: " + postFixExpression);
            Print("Expression evaluation: " + postfixEvaluation(postFixExpression));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ExpressionEvaluation expEval = new ExpressionEvaluation();
        expEval.run();

    }

}
