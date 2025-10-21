package week_5_heaps_hashmap;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    // Inner class to represent elements in the queue
    private static class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "(" + value + ", p=" + priority + ")";
        }
    }

    private List<Node> heap;
    private int capacity;

    // Constructor
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.heap = new ArrayList<>(capacity);
    }

    // ----------------------------
    // Core Methods
    // ----------------------------

    // Insert an element with a given priority
    public void insert(int value, int priority) {
        if (heap.size() >= capacity)
            throw new IllegalStateException("Priority queue is full");

        Node newNode = new Node(value, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return element with highest priority
    public int remove() {
        if (heap.isEmpty())
            throw new IllegalStateException("Priority queue is empty");

        Node root = heap.get(0);
        Node last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root.value;
    }

    // Peek at the element with highest priority
    public int peek() {
        if (heap.isEmpty())
            throw new IllegalStateException("Priority queue is empty");
        return heap.get(0).value;
    }

    // ----------------------------
    // Heapify Methods
    // ----------------------------

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index).priority > heap.get(parentIndex).priority) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap.get(left).priority > heap.get(largest).priority)
                largest = left;
            if (right < size && heap.get(right).priority > heap.get(largest).priority)
                largest = right;

            if (largest == index)
                break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ----------------------------
    // Utility
    // ----------------------------
    public List<String> getHeap() {
        List<String> result = new ArrayList<>();
        for (Node node : heap)
            result.add(node.toString());
        return result;
    }
}
