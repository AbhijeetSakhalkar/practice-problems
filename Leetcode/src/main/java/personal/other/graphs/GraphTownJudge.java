package personal.other.graphs;

import java.util.ArrayList;

// https://leetcode.com/problems/find-the-town-judge/?envType=problem-list-v2&envId=graph
public class GraphTownJudge {


    public int findJudge(int n, int[][] trust) {
        int [] trustArray = new int[n+1];
        for (int [] t : trust) {
            trustArray[t[0]] --;
            trustArray[t[1]] ++;
        }
        for (int i = 1; i < trustArray.length; i++) {
            if (trustArray[i] == n-1) return i;
        }
        return -1;
    }


    public int findJudge2(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> whoTrustsMe = new ArrayList<>();
        int [] trustCount = new int[n+1];
        for (int i = 0 ; i <= n ; i++) {
            whoTrustsMe.add(new ArrayList<>());
        }

        for (int [] arr : trust) {
            whoTrustsMe.get(arr[1]).add(arr[0]);
            trustCount[arr[0]] ++;
        }

        for (int i = 0 ; i < whoTrustsMe.size(); i++) {
            if (whoTrustsMe.get(i).size() == n-1 && trustCount[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
