package striver.dp;

import java.util.Arrays;

public class NonAdjacent {
    public static void main(String[] args) {
        NonAdjacent n = new NonAdjacent();
        int ans = n.nonAdjacentMemoization(new int[]{2, 1, 4, 9});
        System.out.println(ans);
    }

    public int nonAdjacentMemoization(int[] nums) {
        if (nums.length == 0) return 0;
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, dp, nums.length - 1);
    }

    private int helper(int [] nums,int [] dp,  int index) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = nums[index] + helper(nums, dp, index-2);
        int notPick =  helper(nums, dp, index-1);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    public int nonAdjacentTabulization(int[] nums) {
        int [] dp = new int [nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else {
            dp[0] = nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max((nums[0]+nums[2]), nums[1]);
        } else {
            dp[2] = Math.max((nums[0]+nums[2]), nums[1]);
        }
        for (int i = 3 ; i < nums.length ; i++) {
            dp[i] = Math.max(
                    nums[i] + dp[i-2],
                    dp[i-1]
            );
        }
        return dp[nums.length-1];
    }
}
