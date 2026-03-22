package personal.dg.recursion;

public class Factorial {
    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) return number;
        return number * calculateFactorial(number-1);
    }
}
