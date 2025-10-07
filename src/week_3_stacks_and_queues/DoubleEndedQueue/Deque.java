package week_3_stacks_and_queues.DoubleEndedQueue;

public class Deque{
    private int[] deque;
    private int front, rear, size, capacity;

    public Deque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Insert at rear
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full! Cannot insert at rear.");
            return;
        }
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
        if (isFull()) {
            System.out.println("Deque is full! Cannot insert at front.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity; // wrap around
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
            rear = (rear - 1 + capacity) % capacity; // wrap around
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

    // ===== Main method for testing =====
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertFront(2);
        deque.insertRear(25); // deque full now
        deque.insertRear(30); // overflow

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
