package personal.top150;


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int [] arr = new int[]{1,1,2,2,3,3,3,4,5,6,6,6,7,7};
        int ans = r.removeDuplicates(arr);
        System.out.println(r);
        System.out.println(ans);
    }

    public int removeDuplicates(int[] nums) {
        int slow=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1]) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}
