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
	
	private int cost;
	
	
	/* CONSTRUCTORS */
	public Edge() {}
	public Edge(Node<T> start, Node<T> end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	
	/* ACCESSOR METHODS */
	public int getCost() {
		return cost;
	}
	public Node<T> getStart() {
		return start;
	}
	public Node<T> getEnd() {
		return end;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		return "from " + start + " to " + end + " (" + cost + "); ";
	}
}
