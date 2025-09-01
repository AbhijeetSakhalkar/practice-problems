package personal.top150;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
public class BuyAndSellStocks1 {



    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int maxSoFar=Integer.MIN_VALUE;
        for(int i = prices.length-1 ; i >=0 ; i--) {
            if(maxSoFar < prices[i]) {
                maxSoFar = prices[i];
            }
            if(maxProfit < (maxSoFar - prices[i])) {
                maxProfit = (maxSoFar - prices[i]);
            }
        }
        return maxProfit;
    }

}
