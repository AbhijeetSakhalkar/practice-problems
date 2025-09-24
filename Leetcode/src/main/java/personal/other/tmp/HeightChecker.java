package personal.other.tmp;


import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        HeightChecker h = new HeightChecker();
        int ans = h.heightChecker(new int []{1,1,4,2,1,3});
        System.out.println(ans);
    }

    public int heightChecker(int[] heights) {
        int [] newHeight = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newHeight);
        int ans = 0;
        for (int i = 0 ; i  < heights.length ; i++) {
            if(heights[i] != newHeight[i]) {
                ans ++;
            }
        }
        return ans;
    }
}
