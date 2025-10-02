package Circular_Linked_List;

public class CircularLinkedList {
    private CircularNode head;
    private CircularNode tail;
    private int size;

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert at end
    public void insert(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) { // first node
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    // Delete by value
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        CircularNode current = head;
        CircularNode prev = tail;
        boolean found = false;

        do {
            if (current.data == value) {
                found = true;

                // Only one node
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                }
                // Deleting head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Deleting tail
                else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // Deleting middle node
                else {
                    prev.next = current.next;
                }

                size--;
                System.out.println("Deleted value " + value);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Value " + value + " not found.");
        }
    }

    // Search for a value
    public int search(int value) {
        if (head == null) return -1;

        CircularNode current = head;
        int index = 0;

        do {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != head);

        return -1; // not found
    }

    // Traverse the list
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CircularNode current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    // Get size of list
    public int getSize() {
        return size;
    }
}
