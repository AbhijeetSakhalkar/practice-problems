package personal.top150;

import java.util.Arrays;

// https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    public static void main(String[] args) {
        Candy c = new Candy();
        c.candy(new int[]{1,3,4,5,2});
    }

    public int candy(int[] ratings) {
        int [] candies = new int [ratings.length];
        Arrays.fill(candies, 1);
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i=ratings.length-2; i>=0 ; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }

        int ans = 0;
        for(int candy : candies) {
            ans += candy;
        }

        return ans;
    }

}
