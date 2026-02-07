package personal.dg.dsa.search;

public class MaximumCount {
    public int maximumCount(int[] nums) {
        int nCount=0;
        int pCount=0;
        for (int i : nums) {
            if (i < 0) nCount++;
            if (i > 0) pCount++;
        }
        return Math.max(pCount, nCount);
    }
}
