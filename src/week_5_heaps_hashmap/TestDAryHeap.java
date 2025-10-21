package week_5_heaps_hashmap;

public class TestDAryHeap {
    public static void main(String[] args) {
        System.out.println("Testing D-ary Heap with Capacity");

        // Create a D-ary Heap with D = 3 and Capacity = 5
        int d = 3;
        int capacity = 5;
        DaryHeap heap = new DaryHeap(capacity, d);

        // Test: Inserting elements within capacity
        System.out.println("\nInserting elements into the heap:");
        int[] elements = {15, 10, 20, 8, 25};
        for (int element : elements) {
            System.out.println("Inserting: " + element);
            heap.insert(element);
            System.out.println("Heap after insertion: " + heap.getHeap());
        }

        // Test: Inserting an element beyond capacity
        System.out.println("\nAttempting to insert beyond capacity:");
        try {
            heap.insert(30); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test: Removing elements to free up space
        System.out.println("\nRemoving elements from the heap:");
        while (!heap.getHeap().isEmpty()) {
            int min = heap.removeMin();
            System.out.println("Removed Min: " + min);
            System.out.println("Heap after removal: " + heap.getHeap());
        }

        // Test: Reinserting elements after removal
        System.out.println("\nReinserting elements into the heap:");
        int[] newElements = {50, 40};
        for (int element : newElements) {
            System.out.println("Inserting: " + element);
            heap.insert(element);
            System.out.println("Heap after insertion: " + heap.getHeap());
        }

        // Test: Ensuring capacity is respected after reinsertion
        System.out.println("\nFilling up to capacity:");
        try {
            heap.insert(60);
            heap.insert(70);
            heap.insert(55);
            System.out.println("Heap filled: " + heap.getHeap());
            heap.insert(80); // Should trigger exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test buildHeap
        System.out.println("\nBuilding heap from unsorted array:");
        int[] arr = {30, 5, 15, 10, 20};
        heap.buildHeap(arr);
        System.out.println("Heap built from array: " + heap.getHeap());
    }
}

