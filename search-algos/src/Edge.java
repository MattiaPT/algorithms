/*
 * Author: Mattia
 * Date: 14.12.22
 * 
 * This class is being used to store edges in graphs
 * and can be used with any nodes using a comparable Type T.
 */

public class Edge<T extends Comparable<T>> {
	private Node<T> start;
	private Node<T> end;
	
	int cost;
	
	/* CONSTRUCTORS */
	public Edge(Node<T> start, Node<T> end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	/* accessor methods */
	public int getCost() {
		return this.cost;
	}
	@SuppressWarnings("unchecked")
	public Node<T>[] getStartEnd() {
		return (Node<T>[]) new Object[] {this.start, this.end};
	}
	
	public String toString() {
		return "from " + start + " to " + end + " (" + cost + "); ";
	}
}
