package week_3_stacks_and_queues.Queue;

class QueueLinkedList {
    // Node class for linked list
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;

    // Constructor
    public QueueLinkedList() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Enqueue: add element to the end of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {  // Empty queue
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue: remove element from the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        int value = front.data;
        front = front.next;

        if (front == null) // Queue became empty
            rear = null;

        size--;
        return value;
    }

    // Front: get element at the front
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get size
    public int size() {
        return size;
    }
}
