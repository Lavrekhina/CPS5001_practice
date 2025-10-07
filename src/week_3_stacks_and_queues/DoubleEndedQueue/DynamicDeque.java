package week_3_stacks_and_queues.DoubleEndedQueue;
import java.util.Arrays;

public class DynamicDeque {
    private int[] deque;
    private int front, rear, size, capacity;

    // Constructor
    public DynamicDeque(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        capacity = initialCapacity;
        deque = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    private boolean isFull() {
        return size == capacity;
    }

    // Resize array when full
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newDeque = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[(front + i) % capacity];
        }

        deque = newDeque;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        System.out.println("Deque resized to capacity: " + newCapacity);
    }

    // Insert at rear
    public void insertRear(int value) {
        if (isFull()) resize();
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        deque[rear] = value;
        size++;
        System.out.println(value + " inserted at rear.");
    }

    // Insert at front
    public void insertFront(int value) {
        if (isFull()) resize();
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        deque[front] = value;
        size++;
        System.out.println(value + " inserted at front.");
    }

    // Delete from front
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty! Cannot delete from front.");
            return -1;
        }
        int value = deque[front];
        if (size == 1) { // last element
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        System.out.println(value + " deleted from front.");
        return value;
    }

    // Delete from rear
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty! Cannot delete from rear.");
            return -1;
        }
        int value = deque[rear];
        if (size == 1) { // last element
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        System.out.println(value + " deleted from rear.");
        return value;
    }

    // Peek front
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }
        return deque[front];
    }

    // Peek rear
    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }
        return deque[rear];
    }

    // Get current size
    public int size() {
        return size;
    }

    // ===== Main method for testing =====
    public static void main(String[] args) {
        DynamicDeque deque = new DynamicDeque(3);

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertRear(30); // triggers resize
        deque.insertFront(2);

        System.out.println("Front: " + deque.peekFront());
        System.out.println("Rear: " + deque.peekRear());

        deque.deleteFront();
        deque.deleteRear();
        deque.deleteFront();
        deque.deleteRear();
        deque.deleteFront(); // last element
        deque.deleteFront(); // underflow
    }
}
