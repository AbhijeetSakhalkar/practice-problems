package personal.dg.dsa.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers1ToN {

    public static void main(String[] args) {
        String [] ans = generateBinaryNumbers(3);
        System.out.println(Arrays.toString(ans));
    }

    public static String[] generateBinaryNumbers(int n) {
        String[] res = new String[n];
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for(int i = 0 ; i < n ; i++) {
            res[i] = q.poll();
            q.add(res[i] + "0");
            q.add(res[i] + "1");
        }
        return res;
    }
}
