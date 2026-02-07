package personal.dg.dsa.search;

public class MySqrt {
    public int mySqrt(int x) {
        if (x<2) return x;
        int left = 2;
        int right = x/2;
        while (left<=right){
            int mid = left + (right-left)/2;
            long num = (long) mid *mid;
            if (num > x) {
                right = mid -1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(10));
    }
}
