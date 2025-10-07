package week_3_stacks_and_queues.CircularQueue;

public class CircularQueueWithValidation {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public CircularQueueWithValidation(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        System.out.println(value + " enqueued to the queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(value + " dequeued from the queue.");
        return value;
    }

    // Peek at the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing at front.");
            return -1;
        }
        return queue[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }

    // Get current size
    public int size() {
        return size;
    }

    // ===== Main method for testing =====
    public static void main(String[] args) {
        CircularQueueWithValidation queue = new CircularQueueWithValidation(5);

        // Test enqueue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue full

        // Test peek
        System.out.println("Front element: " + queue.peek());

        // Test dequeue
        queue.dequeue();
        queue.dequeue();

        // Test wrap-around enqueue
        queue.enqueue(60);
        queue.enqueue(70);

        // Dequeue all to test wrap-around
        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        // Dequeue from empty queue
        queue.dequeue(); // Underflow
    }
}
