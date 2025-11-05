package personal.dg.dsa.matrix;

public class DiagonalSum {
    public static void main(String[] args) {
        int ans = diagonalSum(new int [][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        System.out.println(ans);
    }
    public static int diagonalSum(int[][] mat) {
        int totalSum = 0;  // Initialize the total sum
        for (int i=0,j=0; i<mat.length; i++,j++) {
            totalSum += mat[i][j];
        }
        for(int i=0,j= mat.length-1;i< mat.length; i++,j--) {
            totalSum += mat[i][j];
        }
        if (mat.length%2 != 0) {
            int mid = mat.length/2;
            totalSum = totalSum - mat[mid][mid];
        }
        return totalSum;  // Return the calculated total sum
    }
}
