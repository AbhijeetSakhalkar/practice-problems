package personal.dg.dsa.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AppleDistribution {
    // Method to determine the minimum number of boxes required to store all apples
    public int distributeApples(int[] apples, int[] boxCapacities) {
        int totalApples = 0;
        for (int apple : apples) {
            totalApples += apple;
        }
        Arrays.sort(boxCapacities);
        int result=0;
        for (int i= boxCapacities.length-1; i>=0; i--) {
            totalApples = totalApples-boxCapacities[i];
            result++;
            if (totalApples <=0) {
                return result;
            }
        }
        return 0;
    }
}
