package personal.dg.dsa.matrix;

public class RichestCustomer {
    public static void main(String[] args) {
        int ans =  maximumWealth(new int [][]{
                {5, 10, 15},
                {10, 20, 30},
                {15, 30, 45}
        });
        System.out.println(ans);
    }
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int custWealth = 0;
            for (int i : account) {
                custWealth += i;
            }
            maxWealth = Math.max(maxWealth, custWealth);
        }
        return maxWealth;
    }
}
