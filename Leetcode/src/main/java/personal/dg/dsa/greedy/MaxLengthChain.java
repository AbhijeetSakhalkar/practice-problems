package personal.dg.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        // Initialize variables
        int currentEnd = Integer.MIN_VALUE;
        int chainCount = 0;
        for (int [] pair: pairs) {
            if (pair[0] > currentEnd) {
                currentEnd = pair[1];
                chainCount ++;
            }
        }
        return chainCount;
    }
}
