package personal.tuf.dp;

// https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber {
    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);
        int tmp=0;
        for(int i=2; i<nums.length;i++) {
            tmp = two;
            two = Math.max(two, one + nums[i]);
            one = tmp;
        }
        return two;
    }

}
