package week_5_heaps_hashmap;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // ----------------------------
    // Helper Methods
    // ----------------------------

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // ----------------------------
    // Core Heap Operations
    // ----------------------------

    // Retrieve maximum element (root)
    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    // Insert a new value into the heap
    public void insert(int value) {
        // Resize dynamically if needed
        if (size == capacity) {
            resize();
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Remove and return the maximum element (root)
    public int removeMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // ----------------------------
    // Heapify Methods
    // ----------------------------

    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // ----------------------------
    // Extension 1: Dynamic Resizing
    // ----------------------------

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newHeap = new int[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, capacity);
        heap = newHeap;
        capacity = newCapacity;
    }

    // ----------------------------
    // Extension 2: Build Heap from Unsorted Array
    // ----------------------------

    public void buildHeap(int[] array) {
        this.heap = array;
        this.size = array.length;
        this.capacity = array.length;

        // Heapify from last non-leaf node down to root
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // ----------------------------
    // Utility Method (for testing)
    // ----------------------------
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
