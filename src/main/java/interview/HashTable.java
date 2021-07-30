package interview;

import java.util.ArrayList;
import java.util.Iterator;

class HashNode<K,V> {
    private K key; // K should be immutable and has implemented hashCode() and equals()
    private V value;

    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    int getKeyHashCode() {
        return key.hashCode();
    }
}

public class HashTable<K,V> {
    private ArrayList<HashNode<K,V>> bucket = new ArrayList<HashNode<K, V>>();
    private int count = 0;

    private int getKeyHashCode(K key) {
        return key.hashCode();
    }

    public void put(K key, V value) {
        synchronized (bucket) {
            if (key == null) return; // In java hashtable doesn't allow NULL as a key, HashMap allows.
            int index = -1;
            for (HashNode<K, V> node : bucket) {
                if (compareKeyTo(key, node)) {
                    index = bucket.indexOf(node);
                    break;
                }
            }
            if (index != -1) {
                bucket.set(index, new HashNode<K, V>(key, value)); // No duplicate key
                count++;
            } else {
                bucket.add(new HashNode<K, V>(key, value));
                count++;
            }
        }
    }

    public boolean remove(K key) {
        synchronized (bucket) {
            for (HashNode<K, V> node : bucket) {
                if (compareKeyTo(key, node)) {
                    bucket.remove(node);
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean compareKeyTo(K key, HashNode<K, V> node) {
        return node.getKey().equals(key) && getKeyHashCode(key) == node.getKeyHashCode();
    }

    public V get(K key) {
        for(HashNode<K,V> node: bucket) {
            if(compareKeyTo(key, node)) {
                return node.getValue();
            }
        }
        return null;
    }

    public Iterator<HashNode<K,V>> getBucket() {
        return bucket.iterator();
    }

    public int size(){
        return count;
    }

    public static void main(String[] args) {
        HashTable<String,String> table = new HashTable<String, String>();

        table.put("abc", "123");
        table.put("abc", "1234");
        System.out.println("Value for abc: " + table.get("abc"));
        table.put("efg", "456");
        table.remove("abc");

        for (Iterator<HashNode<String, String>> it = table.getBucket(); it.hasNext(); ) {
            HashNode<String, String> node = it.next();
            System.out.println("Key: " + node.getKey() + " Value: " + node.getValue());
        }
    }
}
