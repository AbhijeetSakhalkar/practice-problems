package personal.dg.dsa.sort;

import java.util.Arrays;

public class ReduceOperationForEqualArray {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0 ;i < nums.length/2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
        int res=0;
        int l=0;
        while(l<nums.length) {
            if (l < nums.length-1) {
                if (nums[l] == nums[l+1]) {
                    l++;
                } else {
                    l++;
                    res = res+l;
                }
            } else {
              l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReduceOperationForEqualArray r = new ReduceOperationForEqualArray();
        int ans = r.reductionOperations(new int[]{8, 8, 8, 8});
        System.out.println(ans);
    }
}
