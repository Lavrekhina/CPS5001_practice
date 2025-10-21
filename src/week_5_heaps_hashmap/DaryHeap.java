package week_5_heaps_hashmap;

import java.util.ArrayList;
import java.util.List;

public class DaryHeap {
    private List<Integer> heap;
    private int capacity;
    private int d; // number of children per node

    // Constructor
    public DaryHeap(int capacity, int d) {
        if (d < 2) throw new IllegalArgumentException("d must be >= 2");
        this.capacity = capacity;
        this.d = d;
        this.heap = new ArrayList<>(capacity);
    }

    // ---------------------------------
    // Helper Methods
    // ---------------------------------

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    // ---------------------------------
    // Core Heap Operations
    // ---------------------------------

    // Get minimum element (root)
    public int getMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // Insert new element
    public void insert(int value) {
        if (heap.size() >= capacity)
            throw new IllegalStateException("Heap is full");

        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return minimum element
    public int removeMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // ---------------------------------
    // Heapify Operations
    // ---------------------------------

    private void heapifyUp(int index) {
        int current = index;
        int parentIndex = parent(current);

        while (current > 0 && heap.get(current) < heap.get(parentIndex)) {
            swap(current, parentIndex);
            current = parentIndex;
            parentIndex = parent(current);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;

        while (true) {
            int minIndex = smallest;

            for (int k = 1; k <= d; k++) {
                int childIndex = kthChild(smallest, k);
                if (childIndex < heap.size() && heap.get(childIndex) < heap.get(minIndex)) {
                    minIndex = childIndex;
                }
            }

            if (minIndex == smallest)
                break;

            swap(smallest, minIndex);
            smallest = minIndex;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ---------------------------------
    // Extension: Build Heap from Unsorted Array
    // ---------------------------------
    public void buildHeap(int[] array) {
        if (array.length > capacity)
            throw new IllegalStateException("Array exceeds heap capacity");

        heap.clear();
        for (int val : array)
            heap.add(val);

        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // ---------------------------------
    // Utility: Return Heap as List
    // ---------------------------------
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }
}

