import java.util.Stack;

/**
 * Created by fuliang on 2015/4/12.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < tokens.length; ) {
            while (!isOperator(tokens[i])) {
                stack.push(tokens[i]);
                ++i;
            }

            String operator = tokens[i];
            ++i;
            String num2 = stack.pop();
            String num1 = stack.pop();
            String result = compute(num1, num2, operator);
            stack.push(result);
        }
       return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    private String compute(String num1, String num2, String operator) {
        int result = 0;
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if ("+".equals(operator)) {
            result = n1 + n2;
        } else if ("-".equals(operator)) {
            result = n1 - n2;
        } else if ("*".equals(operator)) {
            result = n1 * n2;
        } else {
            result = n1 / n2;
        }
        return String.valueOf(result);
    }

    private static void test(String[] arr) {
        EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
        int result = sol.evalRPN(arr);
        System.out.println(result);
    }

    public static void main(String[] args) {
        //test(new String[]{"2", "1", "+", "3", "*"});
        test(new String[]{"4", "13", "5", "/", "+"});
    }
}
