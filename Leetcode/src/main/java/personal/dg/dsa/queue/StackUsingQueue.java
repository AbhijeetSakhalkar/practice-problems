package personal.dg.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Solution myStack = new Solution();
        myStack.push(5);
        myStack.push(10);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    static class Solution {
        Queue<Integer> q1;
        Queue<Integer> q2;
        public Solution() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        // Push element x onto the stack
        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            if(q1.isEmpty()) return 0;
            while(q1.size() > 1) {
                q2.add(q1.poll());
            }
            if(q1.isEmpty()) return 0;
            int val = q1.poll();
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return val;
        }

        public int top() {
            if(q1.isEmpty()) return 0;
            while(q1.size() > 1) {
                q2.add(q1.poll());
            }
            if(q1.isEmpty()) return 0;
            int val = q1.poll();
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            q1.add(val);
            return val;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }


}
