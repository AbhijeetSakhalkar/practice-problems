package personal.dg.dsa.greedy;

public class MinimumAdditionsToMakeValidParentheses {
    public int minAddToMakeValid(String S) {
        int open = 0;
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                open ++;
            } else {
                if (open <= 0) {
                    ans ++;
                    open = 0;
                } else {
                    open--;
                }
            }
        }
        if (open > 0) {
            ans = ans + open;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumAdditionsToMakeValidParentheses m = new MinimumAdditionsToMakeValidParentheses();
        int ans = m.minAddToMakeValid("(()())(");
        System.out.println(ans);
    }
}
