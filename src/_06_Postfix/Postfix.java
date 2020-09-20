package _06_Postfix;

//********************************************************************
//  Postfix.java       Authors: Lewis/Chase
//
//  Demonstrates the use of a stack to evaluate postfix expressions.
//********************************************************************

import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        String expression, again;
        int result;

        try {
            Scanner in = new Scanner(System.in);

            do {
                PostfixEvaluator evaluator = new PostfixEvaluator();
                System.out.print("Enter a valid postfix expression: ");
                expression = in.nextLine();

                result = evaluator.evaluate(expression);
                System.out.println();
                System.out.println("That expression equals " + result);

                System.out.print("Evaluate another expression [Y/N]? ");
                again = in.nextLine();
                System.out.println();
            } while (again.equalsIgnoreCase("y"));
        } catch (Exception IOException) {
            System.err.println("Input exception reported");
        }
    }
}
