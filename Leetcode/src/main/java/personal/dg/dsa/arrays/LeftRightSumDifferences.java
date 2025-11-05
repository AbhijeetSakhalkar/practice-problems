package personal.dg.dsa.arrays;

import java.util.Arrays;

public class LeftRightSumDifferences {
    public static void main(String[] args) {
        LeftRightSumDifferences l = new LeftRightSumDifferences();
        int [] ans = l.findDifferenceArray(new int [] {2, 5, 1, 6, 1});
        System.out.println(Arrays.toString(ans));
    }
    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int r=0;
        int l=0;
        for (int i = 0 ; i < n ; i ++) {
            r = r + nums[i];
        }
        for (int i = 0 ; i < n ; i ++) {
            r = r - nums[i];
            differenceArray[i] = Math.abs(r - l);
            l = l + nums[i];
        }
        return differenceArray;
    }
}
