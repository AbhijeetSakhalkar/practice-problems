package personal.dg.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> previousRow = triangle.get(i-1);
                    int value = previousRow.get(j-1) + previousRow.get(j);
                    row.add(value);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
