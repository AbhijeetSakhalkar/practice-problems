package personal.other.dp;

public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        // when 1st house is robbed
        // last one cannot be robbed
        int [] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }

        // when 1st house is not robbed
        // last one can be robbed
        int [] dpn1 = new int [n];
        dpn1[0] = 0;
        dpn1[1] = nums[1];
        for(int i = 2 ; i < n; i++) {
            dpn1[i] = Math.max(dpn1[i-1], dpn1[i-2] + nums[i]);
        }

        return Math.max(dpn1[n-1], dp1[n-2]);

    }


}
