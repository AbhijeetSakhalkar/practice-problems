package striver.dp;

import java.util.Arrays;

public class FrogJumpKSteps {
    public static void main(String[] args) {
        FrogJumpKSteps f = new FrogJumpKSteps();
        int [] arr = new int [] {10, 5, 20, 0, 15};
        int k = 2;
        int ans = f.frogJumpTabulization(arr, k);
        System.out.println(ans);
        ans = f.frogJumpMemoization(arr, k);
        System.out.println(ans);
    }


    public int frogJumpTabulization(int[] heights, int k) {
        if (heights.length == 0) return 0;
        int [] dp = new int[heights.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1 ; i < heights.length ; i++) {
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1 ; j <= k ; j++) {
                if (i-j >= 0) {
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[heights.length-1];
    }


    public int frogJumpMemoization(int[] heights, int k) {
        if (heights.length == 0) return 0;
        int [] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return minSteps(dp, heights, heights.length-1, k);
    }
    private int minSteps(int [] dp, int [] heights, int curI, int k) {
        if (curI == 0) return 0;
        if (dp[curI] != -1) return dp[curI];
        int minJump = Integer.MAX_VALUE;
        for (int j = 1; j <=k; j++) {
            if (curI - j >= 0) {
                int jump = minSteps(dp, heights, curI-j, k) + Math.abs(heights[curI]-heights[curI-j]);
                minJump = Math.min(minJump, jump);
            }
        }
        dp [curI] = minJump;
        return minJump;
    }
}
