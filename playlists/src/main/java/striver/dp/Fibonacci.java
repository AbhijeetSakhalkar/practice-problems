package striver.dp;

public class Fibonacci {
    public static void main(String[] args) {
        int input = 40;
        long start = System.currentTimeMillis();
        System.out.println(fibonacciMemoization(input));
        System.out.println("Time taken by memoization: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        System.out.println(fibonacciTabulization(input));
        System.out.println("Time taken by Tabulization: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        System.out.println(memoryOptimisedMemoization(input));
        System.out.println("Time taken by Memory Optimised Memoization: " + (System.currentTimeMillis()-start));
    }

    private static int fibonacciMemoization(int n) {
        if (n < 2) return n;
        return fibonacciMemoization(n-1) + fibonacciMemoization(n-2);
    }

    private static int fibonacciTabulization( int n) {
        if (n < 2) return n;
        int [] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <= n ; i++) {
            arr [i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    private static int memoryOptimisedMemoization(int n) {
        int [] arr = new int [n+1];
        for (int i = 0; i <= n; i++) {
            arr [i] = -1;
        }
        arr[0]=0;
        arr[1]=1;
        return memoryOptimisedMemoization(n, arr);
    }

    private static int memoryOptimisedMemoization(int n, int [] arr) {
        if (n < 2) return n;
        if (arr[n] != -1) return arr[n];
        arr[n] = memoryOptimisedMemoization(n-1, arr) + memoryOptimisedMemoization(n-2, arr);
        return arr[n];
    }
}
