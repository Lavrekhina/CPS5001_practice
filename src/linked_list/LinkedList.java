package linked_list;

class LinkedList {
    // Node definition
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at given index
    public void insertAtIndex(int index, int data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete at given index
    public void deleteAtIndex(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        current.next = current.next.next;
    }

    // Search for an element
    public int search(int key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == key) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // not found
    }

    // Display elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

