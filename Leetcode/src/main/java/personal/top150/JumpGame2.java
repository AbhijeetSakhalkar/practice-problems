package personal.top150;

// https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int farthest=0;
        int end = 0;
        for(int i=0; i < nums.length-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(i == end) {
                jumps ++;
                end = farthest;
            }
        }
        return jumps;
    }

}
