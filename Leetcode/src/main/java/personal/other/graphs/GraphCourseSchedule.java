package personal.other.graphs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/?envType=problem-list-v2&envId=graph
public class GraphCourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean visited [] = new boolean[numCourses];
        boolean recS [] = new boolean[numCourses];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0;i<numCourses;i++) {
            adjList.add(i,new ArrayList<Integer>());
        }
        for(int [] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
        }


        for(int i = 0 ; i < numCourses ; i++) {
            if(! visited[i]) {
                if(isCyclic(adjList, i, visited, recS)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adjList, int vertex, boolean[] visited, boolean [] recS) {
        visited[vertex] = true;
        recS[vertex] = true;
        for(int neighbor : adjList.get(vertex)) {
            if(!visited[neighbor]) {
                if(isCyclic(adjList, neighbor, visited, recS)) {
                    return true;
                }
            }
            else if (recS[neighbor]) return true;
        }
        recS[vertex] = false;
        return false;
    }

}
