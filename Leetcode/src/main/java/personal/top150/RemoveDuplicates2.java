package personal.top150;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        RemoveDuplicates2 r = new RemoveDuplicates2();
        int [] arr = new int[]{1,1,1,2,2,3};
        int ans = r.removeDuplicates(arr);
        System.out.println(r);
        System.out.println(ans);
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return nums.length;
        int one = nums [0];
        int two = nums [1];
        int slowIndex = 2;
        int fastIndex = 2;
        while(fastIndex < nums.length) {
            if(nums[fastIndex] == one && nums[fastIndex] == two) {
                fastIndex ++;
            } else {
                one = two;
                two = nums[fastIndex];
                nums[slowIndex++] = nums[fastIndex++];
            }
        }
        return slowIndex;
    }
}
