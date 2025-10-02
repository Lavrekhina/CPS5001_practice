package arrays_and_linked_lists;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        System.out.println("Adding elements:");
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.display();

        System.out.println("\nInsert 10 at index 2:");
        myArray.insert(2, 10);
        myArray.display();

        System.out.println("\nAccess element at index 3: " + myArray.access(3));

        System.out.println("\nDelete element at index 1:");
        myArray.delete(1);
        myArray.display();

        System.out.println("\nSearch for element 4:");
        int index = myArray.search(4);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
