package personal.top150;

import java.util.Arrays;

public class RotateArray {
    public void rotate1(int[] nums, int k) {
        if (k == 0) return;
        k = k%nums.length;
        int [] tmp = Arrays.copyOf(nums, nums.length);
        for(int i = 0 ; i < tmp.length ; i++) {
            nums[((i+k)%nums.length)] = tmp[i];
        }
    }

    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int [] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
