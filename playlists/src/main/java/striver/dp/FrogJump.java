package striver.dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int [] arr = new int[]{7, 5, 1, 2, 6};
        FrogJump f = new FrogJump();
        System.out.println(f.frogJumpMemoization(arr));
    }

    public int frogJumpMemoization(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return getValue(heights.length - 1, heights, dp);
    }

    private int getValue(int curIndex, int[] heights, int[] dp) {
        // Base Cases
        if (curIndex == 0) return 0;
        if (curIndex == 1) return Math.abs(heights[1] - heights[0]);

        // Return cached result if already calculated
        if (dp[curIndex] != -1) {
            return dp[curIndex];
        }

        // Recursive transitions
        int left = getValue(curIndex - 2, heights, dp);
        int right = getValue(curIndex - 1, heights, dp);

        int leftJump = left + Math.abs(heights[curIndex] - heights[curIndex - 2]);
        int rightJump = right + Math.abs(heights[curIndex] - heights[curIndex - 1]);

        // Memoize and return the result
        dp[curIndex] = Math.min(leftJump, rightJump);
        return dp[curIndex];
    }


    public int frogJumpTabulisation(int[] heights) {
        if (heights.length == 1) return 0;
        if (heights.length == 2) return Math.abs(heights[1]-heights[0]);
        int [] dp = new int [heights.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);
        for (int i = 2 ; i < heights.length ; i++) {
            dp [i] = Math.min(
                    dp[i-2] + Math.abs(heights[i] - heights [i-2]),
                    dp[i-1] + Math.abs(heights[i] - heights [i-1])
            );
        }
        return dp[heights.length-1];
    }

}
