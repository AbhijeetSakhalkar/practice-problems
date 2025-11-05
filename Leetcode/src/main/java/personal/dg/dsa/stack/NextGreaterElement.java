package personal.dg.dsa.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

// next greater element to the right of current element
public class NextGreaterElement {
    public List<Integer> nextLargerElement(List<Integer> arr) {
        Integer [] res = new Integer[arr.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.size()-1; i >=0 ; i--) {
            while(! stack.isEmpty() && stack.peek() <= arr.get(i)) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr.get(i));
        }
        return Arrays.asList(res);
    }
}
