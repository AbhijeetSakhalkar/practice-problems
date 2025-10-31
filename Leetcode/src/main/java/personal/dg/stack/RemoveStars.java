package personal.dg.stack;

import java.util.Stack;

public class RemoveStars {
    public String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c  :str.toCharArray()) {
            if ('*' == c) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
