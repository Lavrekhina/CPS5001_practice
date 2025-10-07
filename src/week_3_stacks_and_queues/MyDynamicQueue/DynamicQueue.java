package week_3_stacks_and_queues.MyDynamicQueue;

public class DynamicQueue {
    private int[] queue;
    private int front, rear, size;

    // Constructor
    public DynamicQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Queue capacity must be > 0");
        }
        queue = new int[initialCapacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (size == queue.length) {
            resize(); // Double the capacity
        }
        rear = (rear + 1) % queue.length;
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
        front = (front + 1) % queue.length;
        size--;
        System.out.println(value + " dequeued from the queue.");
        return value;
    }

    // Peek at the front element
    public int front() {
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

    // Get current size
    public int size() {
        return size;
    }

    // Resize the array when full
    private void resize() {
        int newCapacity = queue.length * 2;
        int[] newQueue = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
        System.out.println("Queue resized to capacity: " + newCapacity);
    }

    // ========== Main for Testing ==========
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue(3);

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20); // triggers resize

        System.out.println("Front element: " + queue.front());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // underflow
    }
}

