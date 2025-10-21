package week_5_heaps_hashmap;

public class TestHashmap {
    public static void main(String[] args) {
        Hashmap<String, Integer> hashmap = new Hashmap<>(10);

        // Inserting key-value pairs
        hashmap.put("Alice", 25);
        hashmap.put("Bob", 30);
        hashmap.put("Charlie", 35);

        System.out.println("Value for 'Alice': " + hashmap.get("Alice")); // Output: 25

        // Checking key existence
        System.out.println("Contains 'Bob': " + hashmap.containsKey("Bob")); // Output: true

        // Removing a key
        System.out.println("Removed 'Charlie': " + hashmap.remove("Charlie")); // Output: true
        System.out.println("Contains 'Charlie': " + hashmap.containsKey("Charlie")); // Output: false

        // Resizing the hashmap
        for (int i = 0; i < 20; i++) {
            hashmap.put("Key" + i, i);
        }

        System.out.println("Hashmap size after resizing: " + hashmap.size()); // Output: 22

        // Retrieving non-existent keys
        System.out.println("Value for 'NonExistent': " + hashmap.get("NonExistent")); // Output: null
    }
}

