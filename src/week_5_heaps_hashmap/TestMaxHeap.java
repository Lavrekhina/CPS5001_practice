package week_5_heaps_hashmap;

public class TestMaxHeap {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(20);
        maxHeap.insert(25);

        System.out.println("Maximum element: " + maxHeap.getMax()); // Output: 25
        System.out.println("Removed: " + maxHeap.removeMax());      // Output: 25
        System.out.println("Maximum element: " + maxHeap.getMax()); // Output: 20

        // Test buildHeap
        int[] arr = {3, 10, 5, 6, 2, 8};
        maxHeap.buildHeap(arr);
        System.out.print("Heap built from array: ");
        maxHeap.printHeap(); // Should print a valid max heap

        // Test dynamic resizing
        for (int i = 30; i <= 80; i += 10) {
            maxHeap.insert(i);
        }
        System.out.print("Heap after dynamic inserts: ");
        maxHeap.printHeap();
    }
}

