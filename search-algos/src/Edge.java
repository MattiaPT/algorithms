public class Edge<T extends Comparable<T>> {
	private Node<T> start;
	private Node<T> end;
	
	int cost;
	
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
}
