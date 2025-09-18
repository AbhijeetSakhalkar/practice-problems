package personal.top150;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        int ans = b.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(ans);
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // start with 0
        for (int i=0, sign = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                for(; i < s.length()-1 && Character.isDigit(s.charAt(i+1)); i++) { // for loop if it is a multiple digit number
                    num = num * 10 + (s.charAt(i+1) - '0');
                }
                stack.push(stack.pop() + (sign * num));
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(0); // calculation inside ( starts here
                sign = 1;
            } else if (s.charAt(i) == ')') {
                stack.push(stack.pop() * stack.pop() + stack.pop());
            } else {
                // white space
            }
        }
        return stack.pop();
    }


    public int calculateChatgptExplained(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start with an initial result of 0
        int sign = 1; // Current sign (+1 or -1)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // Parse the full number (could be multiple digits)
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                // Apply the sign and add to the current accumulated result
                int currentSum = stack.pop();
                stack.push(currentSum + sign * num);

            } else if (c == '+') {
                sign = 1;  // Next number is positive
            } else if (c == '-') {
                sign = -1; // Next number is negative
            } else if (c == '(') {
                // Push the current sign and start a new sum for the expression inside parentheses
                stack.push(sign);   // Save the sign before the '('
                stack.push(0);      // Start fresh for the new sub-expression
                sign = 1;           // Reset sign for inside parentheses
            } else if (c == ')') {
                // Pop the inner expression result
                int innerValue = stack.pop();

                // Pop the sign before parentheses
                int signBeforeParen = stack.pop();

                // Pop the previous accumulated result
                int prevSum = stack.pop();

                // Combine: prevSum + signBeforeParen * innerValue
                stack.push(prevSum + signBeforeParen * innerValue);
            } else {
                // Ignore whitespace
            }
        }

        return stack.pop();  // Final result
    }


    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0, sign = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                for (; i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)); i++) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                }
                stack.push(stack.pop() + sign * num);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(0);
                sign = 1;
            } else if (s.charAt(i) == ')') {
                stack.push(stack.pop() * stack.pop() + stack.pop());
            }
        }
        return stack.pop();
    }
}
