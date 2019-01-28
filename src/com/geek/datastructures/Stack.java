package com.geek.datastructures;

import java.util.Arrays;

public class Stack {
	
	int capacity = 40;
	private int[] dataStore;
	private int top;
	private int size;
	
	
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getDataStore() {
		return dataStore;
	}

	public void setDataStore(int[] dataStore) {
		this.dataStore = dataStore;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Stack() {
		dataStore = new int[capacity];
	}
	
	void push(int element) {
		if(size == capacity) {
			doubleStackSize(capacity*2);
		}
		dataStore[top]=element;
		top++;
		size++;
	}
	
	private void doubleStackSize(int i) {
		capacity = i;
		int[] newStore = new int[capacity];
		for(int k=0;k<dataStore.length;k++) {
			newStore[k]=dataStore[k];
		}
		dataStore = newStore;
		newStore = null;
	}

	int pop() {
		int returnme = dataStore[top-1];
		dataStore = Arrays.copyOf(dataStore, dataStore.length-1);
		top--;
		size--;
		return returnme;
		
	}

}
