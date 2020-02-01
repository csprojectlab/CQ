package hashmap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashMap<K, V> {
	public LinkedList<KVPair> bucketArray[];
	public int size;
	public static final int DEFAULT_SIZE = 10;
	public HashMap() {
		this(DEFAULT_SIZE);
		System.out.println("Creating HashMap.");
	}
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		this.bucketArray = (LinkedList<KVPair>[])new LinkedList[capacity];
		this.size = 0;
	}
	
	public int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}
	
	public void put(K key, V value) {
		int bucketIndex = this.hashFunction(key);
		KVPair pair = new KVPair(key, value);
		if(this.bucketArray[bucketIndex] == null) { // Initialize the linked list of this index.
			this.bucketArray[bucketIndex] = new LinkedList<KVPair>();
			this.bucketArray[bucketIndex].addLast(pair);
			this.size++;
		} else {  // List is initialized. But it may be empty.
			LinkedList<KVPair> bucket = this.bucketArray[bucketIndex];
			int index = bucket.indexOf(pair);
			if(index != -1) {  // Key is already present in the hash map. Update
				KVPair extractedPair = bucket.get(index);
				extractedPair.value = value;
			} else {  // Key is new. Add
				bucket.addLast(pair);
				this.size++;
			}
		}
		double lambda = (this.size*1.0)/this.bucketArray.length;
		if(lambda > 0.7)
			this.reHash();
	}
	
	public V get(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<KVPair> bucket = this.bucketArray[bucketIndex];
		if(bucket == null)
			return null;
		else {  // Bucket for this index exist.
			int index = bucket.indexOf(new KVPair(key, null));
			if(index == -1) {  // key doesn't exist in the bucket.
				return null;
			} else {  // key exist.
				return bucket.get(index).value;
			}
		}
	}
	
	public void remove(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<KVPair> bucket = this.bucketArray[bucketIndex];
		if(bucket == null) // There is no linked list at this index.
			return;
		else {
			if(bucket.remove(new KVPair(key, null)))
				this.size--;			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void reHash() {
		System.out.println("--------------------------- REHASHING -----------------------");
		this.size = 0;
		LinkedList<KVPair> oldBucketArray[] = this.bucketArray;
		this.bucketArray = new LinkedList[oldBucketArray.length*2];  // Double the size.
		for(LinkedList<KVPair> bucket : oldBucketArray) {
			while(bucket != null && !bucket.isEmpty()) {
				KVPair pair = bucket.removeFirst();
				this.put(pair.key, pair.value);
			}
		}
	}
	
	public void display() {
		int index = 0;
		for(LinkedList<KVPair> bucket : this.bucketArray) {
			System.out.println("[" + (index++) + "] : " + bucket);
		}
	}
	
	public Set<K> ketSet() {
		Set<K> set = null;
		for(LinkedList<KVPair> bucket : this.bucketArray) {
			if(bucket != null) {
				if(set == null)
					set = new HashSet<K>();
				for(KVPair pair : bucket)
					set.add(pair.key);
			}
		}
		return set;
	}
	
	public Collection<V> values() {
		Collection<V> collection = null;
		for(LinkedList<KVPair> bucket : this.bucketArray) {
			if(bucket != null) {
				if(collection == null)
					collection = new HashSet<V>();
				for(KVPair pair : bucket)
					collection.add(pair.value);
			}
		}
		return collection;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Aridaman", 91);
		map.put("Ajay", 92);
		map.put("Utkarsh", 93);
		map.put("Rajat", 94);
		map.put("Rahul", 95);
		map.put("Sachin", 96);
		map.put("Kamal", 97);
		map.put("Kamal", 98);  // Testing for duplicate key.
		map.put("Jatin", 99);
		map.display();
		System.out.println("Size of hashmap: " + map.size);  // 8
		System.out.println("Getting the value of Rajat: " + map.get("Rajat"));
		System.out.println("After removing Aridaman: ");
		map.remove("Aridaman");
		map.display();
		System.out.println("Size of HashMap: " + map.size);
		map.remove("ABC");  // This key doesn't exist in the hash-map.
		System.out.println(map.size);  // 7
		System.out.println("KeySet of HashMap: " + map.ketSet());  // 7 keys.
		System.out.println("Values of the HashMap: " + map.values());
	}	
	
	// ---------------------- INNER CLASS ------------------
	private class KVPair {
		K key;
		V value;

		public KVPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object o) {
			@SuppressWarnings("unchecked")
			KVPair other = (KVPair) o;
			if (this.key.equals(other.key))
				return true;
			return false;
		}

		public String toString() {
			return "{" + this.key + "," + this.value + "}";
		}
	}
}

