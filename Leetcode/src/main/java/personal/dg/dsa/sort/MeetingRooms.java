package personal.dg.dsa.sort;

import java.util.*;

public class MeetingRooms {
    public int minMeetingRooms1(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            // If the current meeting starts right after the previous meeting ends, remove it
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            // If a new room is to be assigned, then also we add to the heap.
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        for (int [] interval: intervals) {
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int start = startTimes.get(0);
        int end = endTimes.get(endTimes.size()-1);

        int startIndex = 0;
        int endIndex = 0;

        int occupiedRooms=0;
        int maxRooms=0;

        for (int i = start; i <= end ; i++) {
                if (startIndex < startTimes.size() && startTimes.get(startIndex) == i) {
                    startIndex++;
                    occupiedRooms ++;
                    while (startIndex < startTimes.size() && Objects.equals(startTimes.get(startIndex), startTimes.get(startIndex - 1))) {
                        startIndex++;
                        occupiedRooms ++;
                    }
                }
                if (endIndex < endTimes.size() && endTimes.get(endIndex) == i) {
                    endIndex++;
                    occupiedRooms --;
                    while (endIndex < endTimes.size() && Objects.equals(endTimes.get(endIndex), endTimes.get(endIndex - 1))) {
                        endIndex++;
                        occupiedRooms --;
                    }
                }
                maxRooms = Integer.max(maxRooms, occupiedRooms);
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        MeetingRooms m = new MeetingRooms();
//        System.out.println(m.minMeetingRooms(new int[][]{{10, 15}, {20, 25}, {30, 35}})); // 1
//        System.out.println(m.minMeetingRooms(new int[][]{{10, 20}, {15, 25}, {24, 30}, {5, 14}, {22, 28}, {1, 4}, {27, 35}})); // 3
//        System.out.println(m.minMeetingRooms(new int[][]{{10, 20}, {20, 30}})); // 1
        System.out.println(m.minMeetingRooms(new int[][]{{1, 5}, {1, 5}, {1, 5}})); // 3
    }
}
