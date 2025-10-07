package week_3_stacks_and_queues.PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Enqueue: add element with priority
    public void enqueue(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
        System.out.println(value + " enqueued with priority.");
    }

    // Dequeue: remove element with highest priority
    public int dequeue() {
        if (heap.isEmpty()) {
            System.out.println("Priority Queue is empty! Cannot dequeue.");
            return -1;
        }
        int highest = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        System.out.println(highest + " dequeued from priority queue.");
        return highest;
    }

    // Peek: get highest priority element
    public int peek() {
        if (heap.isEmpty()) {
            System.out.println("Priority Queue is empty!");
            return -1;
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // Heapify up after insertion
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(parent) < heap.get(index)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // Heapify down after removal
    private void heapifyDown(int index) {
        int left, right, largest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            largest = index;

            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ===== Main method for testing =====
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(10);
        pq.enqueue(30);
        pq.enqueue(20);
        pq.enqueue(40);

        System.out.println("Highest priority element: " + pq.peek());

        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
        pq.dequeue();
        pq.dequeue(); // empty
    }
}
