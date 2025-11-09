package personal.dg.dsa.queue;

import java.util.*;

public class MaxOfSubarray {

    public static void main(String[] args) {
        MaxOfSubarray m = new MaxOfSubarray();
        List<Integer> ans = m.printMax(new int []{12, 1, 78, 90, 57}, 3);
        System.out.println(ans);
    }

    public List<Integer> printMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0 ; i < k; i++) {
            q.add(arr[i]);
        }
        Optional<Integer> maxElement = q.stream().max(Integer::compareTo);
        maxElement.ifPresent(result::add);
        for (int i = k ; i < arr.length; i++) {
            q.poll();
            q.add(arr[i]);
            maxElement = q.stream().max(Integer::compareTo);
            maxElement.ifPresent(result::add);
        }

        return result;
    }

}
