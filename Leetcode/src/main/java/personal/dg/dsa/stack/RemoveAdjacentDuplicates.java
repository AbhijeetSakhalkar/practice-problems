package personal.dg.dsa.stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        RemoveAdjacentDuplicates r = new RemoveAdjacentDuplicates();
        String ans = r.removeDuplicates("abbaaca");
        System.out.println(ans);
    }
    public String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }
}
