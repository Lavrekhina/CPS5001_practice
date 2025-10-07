package week_3_stacks_and_queues.PriorityQueue;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public class StablePriorityQueue {

    // Inner class to store value, priority, and insertion order
    private static class Node implements Comparable<Node> {
        int value;
        int priority;
        long insertionOrder; // Used to break ties
        static AtomicLong counter = new AtomicLong(0);

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
            this.insertionOrder = counter.getAndIncrement();
        }

        // Compare first by priority, then by insertionOrder
        @Override
        public int compareTo(Node other) {
            if (this.priority != other.priority) {
                return Integer.compare(other.priority, this.priority); // max-heap: higher priority first
            }
            return Long.compare(this.insertionOrder, other.insertionOrder); // FIFO for same priority
        }
    }

    private PriorityQueue<Node> heap;

    public StablePriorityQueue() {
        heap = new PriorityQueue<>();
    }

    // Enqueue
    public void enqueue(int value, int priority) {
        Node node = new Node(value, priority);
        heap.add(node);
        System.out.println(value + " enqueued with priority " + priority);
    }

    // Dequeue
    public int dequeue() {
        if (heap.isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        Node node = heap.poll();
        System.out.println(node.value + " dequeued with priority " + node.priority);
        return node.value;
    }

    // Peek
    public int peek() {
        if (heap.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return heap.peek().value;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // ===== Main method for testing =====
    public static void main(String[] args) {
        StablePriorityQueue pq = new StablePriorityQueue();

        pq.enqueue(10, 2);
        pq.enqueue(20, 5);
        pq.enqueue(30, 5); // Same priority as 20
        pq.enqueue(40, 1);

        System.out.println("Peek: " + pq.peek()); // Should be 20

        pq.dequeue(); // 20
        pq.dequeue(); // 30 (FIFO among priority 5)
        pq.dequeue(); // 10
        pq.dequeue(); // 40
        pq.dequeue(); // empty
    }
}