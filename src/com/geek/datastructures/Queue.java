package com.geek.datastructures;

import java.util.Arrays;

public class Queue {
	
	private int first=0;
	private int last=0;
	private int[] queueStore;
	private int capacity=50;
	private int size =0;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Queue() {
		queueStore = new int[capacity];
	}
	public int dequeue() {
	 int returnedElement= queueStore[first];
	 queueStore=  Arrays.copyOfRange(queueStore, 1, queueStore.length);
	 size--;
	 return returnedElement;
	}
	public void enqueue(int element) {
		if(size == capacity) {
			doubleQueueStore();
		}
		queueStore[last]=element;
		last++;
		size++;
	}
	private void doubleQueueStore() {
		capacity = capacity*2;
		queueStore =Arrays.copyOf(queueStore, capacity);
	}

}
