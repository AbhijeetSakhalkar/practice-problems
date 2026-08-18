package striver.dp;

public class HouseRobber2 {
    public int houseRobber(int[] money) {
        if (money.length == 1) return money[0];
        int [] arr1 = new int[money.length-1];
        int [] arr2 = new int[money.length-1];
        for (int i = 0 ; i < money.length ; i++) {
            if (i!=0) arr1[i-1] = money[i];
            if (i != money.length-1) arr2[i] = money[i];
        }
        return Math.max(nonAdjacent(arr1), nonAdjacent(arr2));
    }
    private int nonAdjacent(int [] money) {
        int [] dp = new int [money.length];
        if (money.length == 1) {
            return money[0];
        } else {
            dp[0] = money[0];
        }
        if (money.length == 2) {
            return Math.max(money[0], money[1]);
        } else {
            dp[1] = Math.max(money[0], money[1]);
        }
        for (int i = 2 ; i < money.length ; i++) {
            dp[i] = Math.max(
                    dp[i-2] + money[i],
                    dp[i-1]
            );
        }
        return dp[money.length-1];
    }
}
