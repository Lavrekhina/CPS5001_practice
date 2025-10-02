package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Inserting elements:");
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.display();

        System.out.println("\nInsert 10 at beginning:");
        list.insertAtBeginning(10);
        list.display();

        System.out.println("\nInsert 20 at index 2:");
        list.insertAtIndex(2, 20);
        list.display();

        System.out.println("\nDelete element at index 1:");
        list.deleteAtIndex(1);
        list.display();

        System.out.println("\nSearch for element 3:");
        int index = list.search(3);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
