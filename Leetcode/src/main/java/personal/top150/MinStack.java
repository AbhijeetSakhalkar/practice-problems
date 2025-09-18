package personal.top150;


import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150
class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Integer min = Integer.MAX_VALUE;
        for(Integer i : stack){
            min = Math.min(min, i);
        }
        return min;
    }
}

