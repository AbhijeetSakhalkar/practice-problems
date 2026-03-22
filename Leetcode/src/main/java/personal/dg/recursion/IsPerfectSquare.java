package personal.dg.recursion;

public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 1, num);
    }
    private static boolean isPerfectSquare(int num, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = low + (high-low)/2;
        int sq = mid * mid;
        if (sq == num) return true;
        if (sq > num) {
            return isPerfectSquare(num, low, mid-1);
        } else {
            return isPerfectSquare(num, mid+1, high);
        }
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(18));
    }
}
