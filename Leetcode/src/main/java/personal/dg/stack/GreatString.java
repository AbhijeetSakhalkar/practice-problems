package personal.dg.stack;

import java.util.Stack;

public class GreatString {
    public static void main(String[] args) {
        GreatString g = new GreatString();
        String ans = g.makeGood("AaBbCcDdEeff");
        System.out.println(ans);
    }

    public String makeGood(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i = 1 ; i < str.length() ; i++) {
            Character c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character top = stack.peek();
            if (! stack.isEmpty() && Math.abs(c - top) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
