package GraphTheory;
/*
 * Author: Mattia
 * Date: 12.12.22
 * 
 * This class is being used to store nodes of an arbitrary
 * comparable type T in a graph. A unique id is assigned to every
 * node in one graph (the index field).
 */

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	private static int id;
	
	private int index;
	public T value;
	
	
	/* CONSTRUCTORS */
	public Node(T value) {
		this.index = id++;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node<T> other) {
		return ((T) this.value).compareTo((T) other.value);
	}
	
	
	/* MUTATOR METHODS */
	public static void setId(int id) {
		Node.id = id;
	}
	/* ACCESSOR METHODS */
	public int getIndex() {
		return index;
	}
	public T getValue() {
		return value;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		return "(i: " + index + ", v: " + value + ")";
	}
}
