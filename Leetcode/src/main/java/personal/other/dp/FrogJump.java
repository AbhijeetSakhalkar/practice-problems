package personal.other.dp;


import java.util.Arrays;

// https://takeuforward.org/plus/dsa/problems/frog-jump
public class FrogJump {

    public int frogJump(int[] heights) {
        int [] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1;i<heights.length;i++) {
            int jump2 = Integer.MAX_VALUE;
            int jump1 = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            if(i > 1) {
                jump2 = dp[i-2] + Math.abs((heights[i]-heights[i-2]));
            }
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[heights.length-1];
    }



}
