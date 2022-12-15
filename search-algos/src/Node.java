/*
 * Author: Mattia
 * Date: 12.12.22
 * 
 * This class is being used to store nodes of an arbitrary
 * comparable type T in a graph. A unique id is assigned to every
 * node in one graph (the index field).
 */

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	static int id;
	
	int index;
	T value;
	
	/* CONSTRUCTORS */
	public Node(T value) {
		this.index = id++;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node<T> other) {
		return ((T) this.value).compareTo((T) other.value);
	}
	
	public String toString() {
		return "(i: " + index + ", v: " + value + ")";
	}
}
