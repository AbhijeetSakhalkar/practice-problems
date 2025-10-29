package personal.dg.stack;

import java.util.Stack;

public class DecimalToBinaryConversion {

    public static void main(String[] args) {
        String ans = decimalToBinary(11);
        System.out.println(ans);
    }

    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (num > 0) {
            stack.push((char)(num%2+'0'));
            num = num / 2;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
