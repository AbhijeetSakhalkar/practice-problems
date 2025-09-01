package personal.top150;

// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {
    public boolean canJump(int[] nums) {
        int last = 0;
        for (int i=0; i< nums.length ; i++) {
            if(i > last) return false;
            last = Math.max(last, i + nums[i]);
        }
        return true;
    }
}
