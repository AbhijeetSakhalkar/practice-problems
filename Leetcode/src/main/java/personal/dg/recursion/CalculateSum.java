package personal.dg.recursion;

public class CalculateSum {
    public static int calculateSum(int N) {
        if (N == 0) return 0;
        return N + calculateSum(N-1);
    }
}
