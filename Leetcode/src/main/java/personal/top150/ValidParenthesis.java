package personal.top150;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
