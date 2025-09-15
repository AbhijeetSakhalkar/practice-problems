package personal.top150;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        String str = s.simplifyPath("/../");
        System.out.println(str);
    }

    public String simplifyPath(String path) {
        String [] allDirectories = path.split("/");
        Stack <String> stack = new Stack<>();
        for (String s : allDirectories) {
            if (s.isEmpty() || s.equals(".")) {
                // ignore
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

}
