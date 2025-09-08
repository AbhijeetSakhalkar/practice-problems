package personal.top150;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        List<Integer> list = s.spiralOrder(new int [][] {{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(list.toString());
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int rs = 0;
        int cs = 0;
        int re = matrix.length-1;
        int ce = matrix[0].length-1;
        while(rs <= re && cs <= ce) {
            for(int i = cs ; i <= ce && rs <= re ;i++) {
                list.add(matrix[rs][i]);
            }
            rs++;
            for(int i = rs ; i <= re && cs <= ce; i++) {
                list.add(matrix[i][ce]);
            }
            ce--;
            for(int i = ce; i >=cs && rs <= re ; i--) {
                list.add(matrix[re][i]);
            }
            re--;
            for(int i = re; i >= rs && cs <= ce; i--) {
                list.add(matrix[i][cs]);
            }
            cs++;
        }
        return list;
    }
}
