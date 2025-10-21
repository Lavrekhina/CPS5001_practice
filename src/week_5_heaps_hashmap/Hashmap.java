package week_5_heaps_hashmap;

import java.util.LinkedList;

public class Hashmap<K, V> {
    /**
     * Inner class representing a key-value pair (entry) stored in the hashmap.
     */
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets; // Array of linked lists (separate chaining)
    private int capacity; // Initial capacity of the hashmap
    private int count; // Number of key-value pairs stored
    private static final double LOAD_FACTOR_THRESHOLD = 0.75; // Resize trigger

    /**
     * Constructor to initialize the hashmap with a specific capacity.
     */
    @SuppressWarnings("unchecked")
    public Hashmap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Computes the hash index for a given key.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Inserts a key-value pair into the hashmap.
     * If the key already exists, update its value.
     * Time Complexity: O(1) average, O(n) worst (when collisions occur).
     */
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Update if key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // Insert new key-value pair
        bucket.add(new Entry<>(key, value));
        count++;

        // Check if resizing is needed
        if ((double) count / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
    }

    /**
     * Retrieves the value associated with a given key.
     * Returns null if the key does not exist.
     * Time Complexity: O(1) average, O(n) worst case.
     */
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Removes a key-value pair from the hashmap.
     * Returns true if removal was successful, false if key not found.
     * Time Complexity: O(1) average, O(n) worst case.
     */
    public boolean remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a key exists in the hashmap.
     * Time Complexity: O(1) average.
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Returns the number of key-value pairs in the hashmap.
     * Time Complexity: O(1)
     */
    public int size() {
        return count;
    }

    /**
     * Resizes the hashmap when the load factor exceeds the threshold.
     * Time Complexity: O(n)
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;

        buckets = new LinkedList[newCapacity];
        capacity = newCapacity;
        count = 0;

        for (int i = 0; i < newCapacity; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Rehash all old entries
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }
}
