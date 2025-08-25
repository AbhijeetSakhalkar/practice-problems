package personal.top150;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays m = new MergeSortedArrays();
        int [] a = new int[]{1,2,3,0,0,0};
        int [] b = new int[]{4,5,6};
        m.merge(a, a.length-b.length, b, b.length);
        System.out.println(a);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length-1;
        m = m-1;
        n = n-1;
        while(m >=0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        if(m>=0) {
            while(m >=0) {
                nums1[index--] = nums1[m--];
            }
        } else if (n>=0) {
            while(n >= 0) {
                nums1[index--] = nums2[n--];
            }
        }
    }

}
