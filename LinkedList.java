package danielsPackage;

import danielsPackage.LinkedList.Node;

public class LinkedList {
	public static class Node{
		/**
		 * object data from card class
		 */
		private Card data;
		
		/**
		 * object next from node class
		 */
		private Node next;
		
		/**
		 * overloading with one parameter
		 * @param s the 0bject
		 */
		public Node ( Card s ) {
			data = s;
			next = null;
		}
		
		/**
		 * Description: overloading with two parameters
		 * @param s the object
		 * @param n the node
		 */
		public Node ( Card s, Node n) {
			data = s;
			next = n;
		}
		
	}
	
	/**
	 * @param first object from node class
	 */
	private Node first;
	
	/**
	 * @param last object from node class
	 */
	private Node last;
	
	/**
	 * Description: creating a linked list with two objects from node class 
	 */
	public LinkedList() {
		first = null;
		last = null;
	}
	
	/**
	 * Description: check if the list is empty
	 * @return a boolean value
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Description: checks the size of the list
	 * @return the size of the list
	 */
	public int size() {
		int count = 0;
		Node n = first;
		while (n != null) {
			count++;
			n=n.next; 
		}
		return count;
	}
	
	/**
	 * Description: gets the value of the node at that index
	 * @param i the index of the node
	 * @return the value of the node 
	 */
	public Card get ( int i ) {
		if ( i < 0 || i >= size()) {
			System.out.println("Index out of bounds.");
			return null;
		}
		else {
			Node n = first;
			for ( int j = 0; j < i; j++) {
				n=n.next;
			}
			return n.data;
		}
	}
	
	/**
	 * Description: sets the value at that index.
	 * @param i the index of the node
	 * @param s the value to be set with
	 */ 
	public void set ( int i, Card s) {
		if ( i < 0 || i >= size()) {
			System.out.println("Index out of bounds.");
		}
		else {
			Node n = first;
			for (int j = 0; j < i; j++) {
				n=n.next;
			}
			n.data = s;
		}
	}
	
	/**
	 * Description: add a node to the linked list
	 * @param s the object to be added
	 */
	public void add( Card s ) {
		if ( isEmpty( )) {
			first = new Node ( s );
			last = first;
		}
		else {
			Node n = new Node ( s );
			last.next = n;
			last = n;
		}
	}
	
	public Card remove(int i)
	{
		Card rem =null;
		if( i < 0 || i >= size())
		{
			System.out.println("Index OOB");
		}
		else {
			if(i==0)
			{
				rem = first.data;
				first = first.next;
				if(first==null) {
					last =null;
				}
			}
			else
			{
				Node n = first;
				for(int j = 0; j < i-1; j++)
				{
					n = n.next;
				}
				rem = n.next.data;
				n.next = n.next.next;
				if(n.next == null)
				{
					last = n;
				}
			}
		}
		return rem;
	}

}
