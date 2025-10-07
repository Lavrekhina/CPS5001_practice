package week_3_stacks_and_queues.Queue;

public class Main {
    public static void main(String[] args) {
        // Create a new queue
        QueueLinkedList queue = new QueueLinkedList();

        // Enqueue elements
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);

        // Access the front element
        System.out.println("Front element: " + queue.front()); // Output: 5

        // Dequeue two elements
        queue.dequeue(); // Removes 5
        queue.dequeue(); // Removes 10

        // Check the new front
        System.out.println("Front element now: " + queue.front()); // Output: 15

        // Enqueue more elements
        queue.enqueue(25);
        queue.enqueue(30);

        // Dequeue remaining elements
        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        // Try to dequeue from empty queue
        queue.dequeue(); // "Queue underflow!"
    }
}
