package personal.dg.dsa.search;

public class Search2DMatrix {
    // Searches for target value in a matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean ans = search2DMatrix.searchMatrix(new int [][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5);
        System.out.println(ans);
    }
}
