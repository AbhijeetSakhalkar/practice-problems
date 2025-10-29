package personal.daily;

public class MaxOnes {
    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;

        for (int i = 0 ; i < mat.length ; i++) {
            int count=0;
            for (int j = 0 ; j < mat[i].length ; j++) {
                count+= mat[i][j];
            }
            if (count > maxOnesCount) {
                maxOnesCount = count;
                maxOnesIdx = i;
            }
        }

        return new int[]{maxOnesIdx, maxOnesCount};
    }
}
