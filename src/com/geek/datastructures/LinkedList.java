package com.geek.datastructures;

public class LinkedList<E> {

	private Node<E> first;
	private Node<E> last;
	private int nodeCount;

	int size() {
		return nodeCount;
	}

	private class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	public boolean add(E item) {
		Node<E> newnode = new Node<E>(last, item, null);
		if(first ==null) {
			first = newnode;
			last = newnode;
			nodeCount++;
		}else {
			last.next = newnode;
		    last =newnode;
		    nodeCount++;
		}
		return true;
	}
	
	public E get(int index) {
		 return node(index).item;
	}

	private Node<E> node(int index) {
		Node<E> x =null;
		if(index < (nodeCount >> 1)) {
			 x =first;
			for (int i=0;i<index;i++) 
				x = x.next;
		}else {
			x =last;
			for(int i=nodeCount-1;i>index;i--) {
				x = x.prev;
			}
		}
		return x;
		}
	
	public void printALL() {
		LinkedList<E>.Node<E> x = first;
		printRecursive(x);
	}

	private void printRecursive(Node<E> x) {
		System.out.println(x.item);
		if(x.next != null)
			printRecursive(x.next);
	}
	
	//removes the first occurence of element in list
	public boolean remove(E item) {
		unlink(item);
		return true;
	}

	private void unlink(E item) {
	if(item.equals(first.item)) {
		first= first.next;		
		first.prev = null;
	}else if(last.item.equals(item)) {
		last = last.prev;
		last.next = null;
	}else {
     for(Node<E> x=first;x.next!=null;x = x.next) {
    	 if(x.item.equals(item)) {
    		x.prev.next=  x.next;
    	 }
     }
	}
	}
}
