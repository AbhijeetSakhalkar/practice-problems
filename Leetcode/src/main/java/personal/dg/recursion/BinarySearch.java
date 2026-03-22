package personal.dg.recursion;

public class BinarySearch {

    public static boolean binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private static boolean binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) return false;
        int mid = low + (high-low)/2;
        if (nums[mid] == target) return true;
        if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid-1);
        } else {
            return binarySearch(nums, target, mid+1, high);
        }
    }
}
