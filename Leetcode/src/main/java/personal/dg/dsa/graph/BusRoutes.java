package personal.dg.dsa.graph;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        // Map bus stops to buses that visit them
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (! stopToBuses.containsKey(stop)) {
                    stopToBuses.put(stop, new ArrayList<>());
                }
                stopToBuses.get(stop).add(i);
            }
        }

        // BFS Setup
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set <Integer> usedBuses = new HashSet<>();

        queue.offer(new int[]{source, 0});
        visitedStops.add(source);

        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int stop = current[0];
            int buses = current[1];

            for (int bus : stopToBuses.get(stop)) {
                if (usedBuses.contains(bus)) continue;
                usedBuses.add(bus);
                for (int nextStop : routes[bus]) {
                    if (nextStop == target) return buses + 1;
                    if (! visitedStops.contains(nextStop)) {
                        visitedStops.add(nextStop);
                        queue.offer(new int[]{nextStop, buses + 1});
                    }
                }
            }
        }

        return -1; // If target is not reachable, return -1
    }
}
