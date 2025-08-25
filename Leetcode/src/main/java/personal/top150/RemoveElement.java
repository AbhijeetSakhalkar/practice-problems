package personal.top150;

public class RemoveElement {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r) {
            if(nums[r] == val) {
                r--;
            } else if (nums[l] == val) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            } else {
                l ++;
            }
        }
        return l;
    }
}
