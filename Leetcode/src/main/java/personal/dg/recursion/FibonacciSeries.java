package personal.dg.recursion;

import java.util.*;

public class FibonacciSeries {

    private static Map<Integer, Integer> memoizationTable ;

    public static List<Integer> fibonacci(int n) {
        memoizationTable = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            result.add(fibonacciRec(i));
        }
        return result;
    }

    public static int fibonacciRec(int n) {
        if (n == 0 || n == 1) {
            return n; // Base case: return n if n is 0 or 1
        }

        // Check if Fibonacci number is already calculated and stored in memoization table
        if (memoizationTable.containsKey(n)) {
            return memoizationTable.get(n);
        }

        // Calculate Fibonacci number using recursion
        int fib = fibonacciRec(n - 1) + fibonacciRec(n - 2);

        // Store Fibonacci number in memoization table for future use
        memoizationTable.put(n, fib);

        return fib;
    }

    public static void main(String[] args) {
        List<Integer> ans = FibonacciSeries.fibonacci(5);
        System.out.println(ans);
    }

}
