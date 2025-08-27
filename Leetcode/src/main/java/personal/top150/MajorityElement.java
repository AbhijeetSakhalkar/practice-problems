package personal.top150;

import java.util.Arrays;

// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[]{6,5,5,4,5,8,5}));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

}
