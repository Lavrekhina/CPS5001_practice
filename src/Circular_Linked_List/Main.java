package Circular_Linked_List;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        System.out.println("Inserting elements:");
        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);
        cll.traverse();

        System.out.println("\nSearching for 30:");
        int index = cll.search(30);
        System.out.println(index != -1 ? "Found at index " + index : "Not found");

        System.out.println("\nDeleting 20:");
        cll.delete(20);
        cll.traverse();

        System.out.println("\nDeleting 100 (not in list):");
        cll.delete(100);

        System.out.println("\nList size: " + cll.getSize());
    }
}
