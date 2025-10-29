package personal.dg.stack;

import java.util.Stack;

public class ReverseString {
    public String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (! stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
