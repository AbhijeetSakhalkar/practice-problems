package personal.top150;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
public class TwoSum2 {

    public static void main(String[] args) {
        TwoSum2 t = new TwoSum2();
        t.twoSum(new int []{2,7,11,15}, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }

        }

        for(int i : nums) {
            int b = target - i;
            if(map.containsKey(b)) {
                if(b == i) {
                    if (map.get(i).size()>1)  {
                        return new int []{map.get(i).get(0), map.get(i).get(1)};
                    }
                } else {
                    return new int []{map.get(i).get(0), map.get(b).get(0)};
                }
            }
        }
        return new int[2];
    }

}
