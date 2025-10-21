package week_5_heaps_hashmap;

public class TestPriorityQueue {
    public static void main(String[] args) {
        // Initialize PriorityQueue with capacity of 10
        PriorityQueue pq = new PriorityQueue(10);

        // Insert elements with priorities
        pq.insert(5, 1);  // Element 5 with priority 1
        pq.insert(10, 5); // Element 10 with priority 5
        pq.insert(3, 2);  // Element 3 with priority 2
        pq.insert(8, 4);  // Element 8 with priority 4

        // Peek at the highest priority element
        System.out.println("Peek (Highest Priority): " + pq.peek()); // Should output 10

        // Remove elements one by one
        System.out.println("Removed: " + pq.remove()); // Should remove 10
        System.out.println("Removed: " + pq.remove()); // Should remove 8
        System.out.println("Peek (Highest Priority): " + pq.peek()); // Should output 3

        // Insert more elements
        pq.insert(20, 6);
        pq.insert(15, 3);

        // Remove elements
        System.out.println("Removed: " + pq.remove()); // Should remove 20
        System.out.println("Removed: " + pq.remove()); // Should remove 15

        // Check if the queue works with remaining elements
        System.out.println("Peek (Highest Priority): " + pq.peek()); // Should output 3
        System.out.println("Removed: " + pq.remove()); // Should remove 3
        System.out.println("Removed: " + pq.remove()); // Should remove 5

        // Test empty queue
        try {
            System.out.println("Peek: " + pq.peek()); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println("Removed: " + pq.remove()); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

