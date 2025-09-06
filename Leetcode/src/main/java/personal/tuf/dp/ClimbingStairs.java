package personal.tuf.dp;

// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 2) return n;
        int one = 1;
        int two = 2;
        for(int i = 2; i < n; i++) {
            int tmp = two;
            two = one + two;
            one = tmp;
        }
        return two;
    }
}
