package com.geek.datastructures;

import java.util.Objects;

public class HashTable<K,V> {
	
	private Node<K,V>[] nodes  = null;
	
	public HashTable() {
		 nodes = new Node[100];
	}
	
	void put(K key,V value) {
		int hash = Objects.hash(key);
	}
	
	
	class Node<K,V> {
		private K key;
		private V value;
		private int hash;
		private HashTable<K, V>.Node<K, V> next;
		public Node(K key, V value, int hash, HashTable<K, V>.Node<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
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
		public int getHash() {
			return hash;
		}
		public void setHash(int hash) {
			this.hash = hash;
		}
		public HashTable<K, V>.Node<K, V> getNext() {
			return next;
		}
		public void setNext(HashTable<K, V>.Node<K, V> next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return this.key+"-"+"value";
		}
		
		  public final int hashCode() {
	            return Objects.hashCode(key) ^ Objects.hashCode(value);
	        }
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			Node<K,V> input = (Node<K,V>)obj;
			if(this == obj) {
				return true;
			}else if(Objects.equals(this.key,input.key) && Objects.equals(this.value, input.value)){
				return true;
			}else {
				return false;
			}
		}
		
	}
	

}
