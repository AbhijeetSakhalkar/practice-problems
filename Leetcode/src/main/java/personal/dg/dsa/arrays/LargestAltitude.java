package personal.dg.dsa.arrays;

public class LargestAltitude {
    public static void main(String[] args) {
        LargestAltitude l = new LargestAltitude();
        int ans = l.largestAltitude(new int[]{4, -3, 2, -1, -2});
        System.out.println(ans);
    }
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0; // To store the maximum altitude encountered
        int sum = 0;
        for (int i = 0 ; i < gain.length ; i ++) {
            sum += gain[i];
            if (sum > maxAltitude) {
                maxAltitude = sum;
            }
        }
        return maxAltitude;
    }
}
