package personal.dg.dsa.queue;

import java.util.*;

public class ZigZagIterator {

    public static void main(String[] args) {

        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        List<Integer> v2 = new ArrayList<>();
        v2.add(4);
        v2.add(5);
        v2.add(6);
        Solution s = new Solution(v1, v2);
        for (int i = 0; i < v1.size()+v2.size(); i++) {
            System.out.println(s.next());
            System.out.println(s.hasNext());
        }

    }

    static class Solution {
        Queue <Integer> q;
        public Solution(List<Integer> v1, List<Integer> v2) {
            q = new LinkedList<>();
            int size = v1.size()+v2.size();
            for (int i = 0 ; i < size;) {
                if(!v1.isEmpty()) {
                    q.add(v1.remove(0));
                    i ++;
                }
                if (! v2.isEmpty()) {
                    q.add(v2.remove(0));
                    i++;
                }
            }
        }

        public int next() {
            return q.poll();
        }

        public boolean hasNext() {
            return ! q.isEmpty();
        }
    }

    static class Solution2 {

        List<Integer> v1;
        List<Integer> v2;
        int index;
        int index1;
        int index2;

        public Solution2(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
            this.index = 0;
            this.index1 = 0;
            this.index2 = 0;
        }

        public int next() {
            if (index % 2 == 0) {
                if (index1 < v1.size()) {
                    index++;
                    return v1.get(index1++);
                } else if (index2 < v2.size()) {
                    index++;
                    return v2.get(index2++);
                } else {
                    return -1;
                }
            } else {
                if (index2 < v2.size()) {
                    index++;
                    return v2.get(index2++);
                } else if (index1 < v1.size()) {
                    index++;
                    return v1.get(index1++);
                } else {
                    return -1;
                }
            }
        }

        public boolean hasNext() {
            return !(index1 == v1.size() && index2 == v2.size());
        }
    }
}
