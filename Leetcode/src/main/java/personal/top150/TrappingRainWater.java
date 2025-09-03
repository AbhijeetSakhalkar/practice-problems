package personal.top150;

// https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
public class TrappingRainWater {

    public int trap2(int[] height) {
        int [] lMax = new int [height.length];
        int [] rMax = new int [height.length];

        // fill lMax
        lMax[0] = height[0];
        for(int i = 1; i < height.length; i ++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        // fill rMax
        rMax[height.length - 1] = height[height.length-1];
        for(int i = height.length-2;i >=0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int ans = 0;
        for(int i = 0 ; i < height.length; i++) {
            ans += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return ans;
    }

    public int trap (int [] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0, ans = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }

}
