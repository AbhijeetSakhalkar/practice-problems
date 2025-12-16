package personal.other.tmp;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Java8 {
    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,4,5,6};
        OptionalDouble avg = Arrays.stream(array).average();
        System.out.println(avg.isPresent() ? avg.getAsDouble() : 0);
    }
}
