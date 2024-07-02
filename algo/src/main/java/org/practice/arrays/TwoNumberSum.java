package org.practice.arrays;

import java.util.Arrays;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length-1;
        while(i < j) {
            if(array[i] + array[j] < targetSum) {
                i++;
            }
            else if(array[i] + array[j] > targetSum) {
                j--;
            }
            else{
                return new int[] {array[i], array[j]};
            }
        }
        return new int[0];
    }
}
