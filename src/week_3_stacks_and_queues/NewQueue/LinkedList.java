package week_3_stacks_and_queues.NewQueue;

public class LinkedList {
    private LinkedListNode first;
    private LinkedListNode last;

    // Constructor (initialize with first node)
    public LinkedList(int value) {
        first = new LinkedListNode(value);
        last = first;
    }

    // Add element to the end
    public void addLast(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        last.setNext(newNode);
        last = newNode;
    }

    // Remove element from the front
    public int removeFirst() {
        if (first == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int value = first.getValue();
        first = first.getNext();
        return value;
    }

    // Display all nodes
    public void display() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }
        LinkedListNode current = first;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    // Check if empty
    public boolean isEmpty() {
        return first == null;
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);
        list.addLast(20);
        list.addLast(30);
        list.display();
        list.removeFirst();
        list.display();
    }
}
