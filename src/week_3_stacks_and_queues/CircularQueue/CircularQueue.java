package week_3_stacks_and_queues.CircularQueue;

public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Peek at front element
    public int peek() {
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
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element: " + queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(60);
        queue.enqueue(70);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}