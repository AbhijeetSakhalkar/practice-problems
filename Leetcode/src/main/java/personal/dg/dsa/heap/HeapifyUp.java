package personal.dg.dsa.heap;

import java.util.ArrayList;

public class HeapifyUp {
    // heapifyUp or percolateUp method in MinHeap
    public static void heapifyUp(ArrayList<Integer> heap, int i) {
        int parent = (i-1)/2;
        if (i > 0 && heap.get(i) < heap.get(parent)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, tmp);

            // recursively heapify the parent
            heapifyUp(heap, parent);
        }
    }

    public static void insert(ArrayList<Integer> heap, int value) {
        heap.add(value);
        heapifyUp(heap, heap.size()-1);
    }

    // Print the heap
    static void printHeap(ArrayList<Integer> heap) {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();

        // Initial Min Heap from the given example
        heap.add(13);
        heap.add(21);
        heap.add(16);
        heap.add(24);
        heap.add(31);
        heap.add(19);
        heap.add(68);
        heap.add(65);
        heap.add(26);
        heap.add(32); // Existing elements

        // Insert 14 into the heap
        insert(heap, 14);

        // Print the heap after insertion
        printHeap(heap);
    }

}
