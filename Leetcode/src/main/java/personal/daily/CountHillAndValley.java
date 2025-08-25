package org.daily;

import java.util.Arrays;

public class CountHillAndValley {

    public static void main (String args[]) {
        CountHillAndValley c = new CountHillAndValley();
        System.out.println(c.countHillValley(new int [] {1,2,3,4,5}));
    }

    public int countHillValley(int[] nums) {
        if (nums.length < 3) return 0;
        int result = 0;
        int left = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if ((nums[i] > nums[left] && nums[i] > nums[i + 1]) ||
                        (nums[i] < nums[left] && nums[i] < nums[i + 1])) {
                    result++;
                }
                left = i;
            }
        }

        return result;
    }
}
