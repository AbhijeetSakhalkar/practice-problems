package personal.dg.dsa.stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        String ans = s.simplifyPath("/a//b////c/d//././/..");
        System.out.println(ans);
    }

    public String simplifyPath(String path) {
        String [] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : arr) {
            if (s.equals("/") || s.equals(".")|| s.isEmpty()) {}
            else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return "/" + String.join("/", stack);
    }
}
