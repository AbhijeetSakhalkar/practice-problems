package personal.dg.stack;


public class MyStackUsingArray {
    private int capacity;
    private int [] stack;
    int top;

    public MyStackUsingArray(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push (int val) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push " + val);
            return;
        }
        stack[++top] = val;
        System.out.println(val + " pushed to stack.");
    }

    //
    public boolean isEmpty() {
        return top == -1;
    }

    // Pop operation
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1; // Return -1 to indicate error
        }
        return stack[top--];
    }

    // Peek Operation
    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1; // Return -1 to indicate error
        }
        return stack[top];
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        MyStackUsingArray stack = new MyStackUsingArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek()); // Output: 30

        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 20

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Popped: " + stack.pop()); // Popping last element
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
        stack.pop();
    }

}
