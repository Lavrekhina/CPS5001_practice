package arrays_and_linked_lists;

import java.util.Arrays;

public class MyArray {
    private int[] arr;
    private int size; // number of elements actually stored

    // Constructor with default capacity
    public MyArray() {
        this.arr = new int[4]; // initial small capacity
        this.size = 0;
    }

    // Constructor with given capacity
    public MyArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.arr = new int[capacity];
        this.size = 0;
    }

    // Display elements
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr, size)));
    }

    // Get current size
    public int getSize() {
        return size;
    }

    // Access element by index
    public int access(int index) {
        validateIndex(index);
        return arr[index];
    }

    // Insert element at given index
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        ensureCapacity(size + 1);

        // Shift elements to the right
        System.arraycopy(arr, index, arr, index + 1, size - index);

        arr[index] = element;
        size++;
    }

    // Append element at end
    public void add(int element) {
        ensureCapacity(size + 1);
        arr[size++] = element;
    }

    // Delete element at index
    public void delete(int index) {
        validateIndex(index);

        // Shift elements to the left
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;

        // Optionally shrink array if too empty
        if (size > 0 && size <= arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    // Search for an element
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1; // not found
    }

    // Ensure array has enough capacity
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            resize(arr.length * 2); // double capacity
        }
    }

    // Resize underlying array
    private void resize(int newCapacity) {
        arr = Arrays.copyOf(arr, newCapacity);
    }

    // Validate index
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
