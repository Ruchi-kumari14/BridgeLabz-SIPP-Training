import java.util.*;

public class MyCustomHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Node<K, V>[] buckets;

    public MyCustomHashMap() {
        buckets = new Node[capacity];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update value
                return;
            }
            head = head.next;
        }

        // Insert at head of list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Not found
    }

    // Remove a key from the map
    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Display contents
    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets[i];
            if (head != null) {
                System.out.print(i + ": ");
                while (head != null) {
                    System.out.print("[" + head.key + "=" + head.value + "] -> ");
                    head = head.next;
                }
                System.out.println("null");
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        MyCustomHashMap<String, Integer> map = new MyCustomHashMap<>();
        map.put("apple", 100);
        map.put("banana", 150);
        map.put("cherry", 120);
        map.put("banana", 175); // update

        map.display();

        System.out.println("Get apple: " + map.get("apple"));
        System.out.println("Get banana: " + map.get("banana"));

        map.remove("banana");
        System.out.println("After removing banana:");
        map.display();
    }
}
