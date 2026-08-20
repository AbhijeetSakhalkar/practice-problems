package gfg.dp;

public class LucasNumber {
    public static void main(String[] args) {
        LucasNumber l = new LucasNumber();
        long ans = l.lucas(5);
        System.out.println(ans);
    }
    public long lucas(int n) {
        if (n==0) return 2;
        if (n==1) return 1;
        long prev2 = 2;
        long prev = 1;
        long ans = 0;
        for (long i = 2 ; i <= n; i++) {
            ans = prev + prev2;
            if (i<n) {
                prev2 = prev;
                prev = ans;
            }
        }
        return ans;
    }
}
