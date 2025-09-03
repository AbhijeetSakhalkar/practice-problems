package personal.top150;

// https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
public class MinimumSubArrayLength {


    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; int sum = 0; int min = Integer.MAX_VALUE;
        for(int right = 0 ; right < nums.length ; right++) {
            sum = sum + nums[right];
            while(sum >= target) {
                min = Math.min(min, (right-left+1));
                sum = sum - nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
