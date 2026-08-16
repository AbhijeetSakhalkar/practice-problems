package striver.dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int prev2=2;
        int prev1=1;
        int tmp = 0;
        for (int i = 2; i <n ; i++) {
            tmp = prev2;
            prev2 = prev1 + prev2;
            prev1 = tmp;
        }
        return prev2;
    }
}
