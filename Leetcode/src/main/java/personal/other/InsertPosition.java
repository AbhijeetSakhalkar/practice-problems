package personal.other;

// https://leetcode.com/problems/search-insert-position/description/?envType=problem-list-v2&envId=array
public class InsertPosition {

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i < nums.length && nums[i] < target) {
            i ++;
        }
        return i;
    }
}
