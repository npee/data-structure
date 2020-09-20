package _06_Postfix;

//********************************************************************
//  PostfixEvaluator.java       Authors: Lewis/Chase
//
//  Represents an evaluator of postfix expressions. Assumes the
//  operands are constants.
//********************************************************************

import structures.LinkedStack;
import structures.StackADT;

import java.util.StringTokenizer;

public class PostfixEvaluator {

    // private LinkedStack<Integer> stack;
    private StackADT<Integer> stack;

    public PostfixEvaluator() {
        stack = new LinkedStack<>();
    }

    public int evaluate(String expr) {

        int result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (isOperator(token)) {
                result = evalSingleOp(token.charAt(0), stack.pop(), stack.pop());
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return result;
    }


    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private int evalSingleOp (char operation, int op1, int op2) {
        int result = 0;

        switch (operation) {
            case '+':
                result = op2 + op1;
                break;
            case '-':
                result = op2 - op1;
                break;
            case '*':
                result = op2 * op1;
                break;
            case '/':
                result = op2 / op1;
        }
        return result;
    }
}
