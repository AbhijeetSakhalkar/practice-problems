package personal.tuf.dp;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        long startTime = System.currentTimeMillis();
        f.fibonacci(40);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }

    private void fibonacci(int n) {
        /*System.out.println(fibonacciRecursive(n));*/

        /*int [] dpArray = new int[n+1];
        Arrays.fill(dpArray, -1);
        System.out.println(fibonacciMemoiazation(dpArray, n));*/

        /*System.out.println(fibonacciTabulation(n));*/

        System.out.println(fibonacciTabulationOptimized(n));
    }

    private int fibonacciRecursive(int i) {
        if(i < 1) return 0;
        if(i == 1) return 1;
        return fibonacciRecursive(i-1) + fibonacciRecursive(i-2);
    }

    private int fibonacciMemoiazation(int [] dpArray, int i) {
        if(dpArray[i] != -1) return dpArray[i];
        if(i < 1) return 0;
        if(i == 1) return 1;
        dpArray[i] = fibonacciMemoiazation(dpArray, i-1) + fibonacciMemoiazation(dpArray, i-2);
        return dpArray[i];
    }

    private int fibonacciTabulation(int n) {
        int [] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2 ; i <= n ; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

    private int fibonacciTabulationOptimized(int n) {
        int one =  0;
        int two =  1;
        int tmp;
        for(int i = 2 ; i <= n ; i++) {
            tmp = two;
            two = one + two;
            one = tmp;
        }
        return two;
    }

}
