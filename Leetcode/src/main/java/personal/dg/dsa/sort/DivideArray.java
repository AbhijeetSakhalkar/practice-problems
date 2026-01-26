package personal.dg.dsa.sort;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DivideArray {
    // Method to divide the array into subarrays with max difference <= k
    public List<List<Integer>> divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l=0;
        while(l <= nums.length-3) {
            if (nums[l+2] - nums[l] <=k) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < 3 ; i++) {
                    list.add(nums[l+i]);
                }
                result.add(list);
                l = l+3;
            } else {
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DivideArray divideArray = new DivideArray();
        List<List<Integer>> ans = divideArray.divideArray(new int[]{1, 2, 4, 5, 9, 10}, 1);
        System.out.println(ans);

    }
}
