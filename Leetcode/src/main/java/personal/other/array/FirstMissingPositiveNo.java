package personal.other.array;


import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositiveNo {
    public static void main(String[] args) {
        FirstMissingPositiveNo f = new FirstMissingPositiveNo();
        int ans = f.firstMissingPositive(new int []{3,4,-1,1});
        System.out.println(ans);
    }
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i > 0) {
                set.add(i);
            }
        }
        int index = 1;
        while (set.contains(index)) {
            index ++;
        }
        return index;
    }
}
