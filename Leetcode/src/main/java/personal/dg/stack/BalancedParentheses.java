package personal.dg.stack;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        BalancedParentheses b = new BalancedParentheses();
        System.out.println(b.isValid("{[()]}"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '}') {
                if (stack.pop() != '{') return false;
            } else if (c == ']') {
                if (stack.pop() != '[') return false;
            } else if (c == ')') {
                if (stack.pop() != '(') return false;
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
