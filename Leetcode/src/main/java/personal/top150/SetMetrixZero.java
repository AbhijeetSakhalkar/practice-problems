package personal.top150;


import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150
public class SetMetrixZero {

    public static void main(String[] args) {
        SetMetrixZero s = new SetMetrixZero();
        s.setZeroes(new int [][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(Integer row : rows) {
            for(int i = 0 ; i < matrix[0].length ; i++) {
                matrix[row][i] = 0;
            }
        }

        for(Integer column : columns) {
            for(int i = 0 ; i < matrix.length ; i++) {
                matrix[i][column] = 0;
            }
        }

        System.out.println(matrix);
    }

}
