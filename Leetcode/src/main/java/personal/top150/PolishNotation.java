package personal.top150;


import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
public class PolishNotation {

    public static void main(String[] args) {
        PolishNotation p = new PolishNotation();
        int ans = p.evalRPN(new String [] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(ans);
    }

    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
