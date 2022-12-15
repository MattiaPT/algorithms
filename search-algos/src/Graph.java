import java.util.ArrayList;

/*
 * Author: Mattia
 * Date: 13.12.22
 * 
 * This class is being used to bundle information about
 * the structure of a given graph and handles its creation.
 */

public class Graph<T extends Comparable<T>> {
	private ArrayList<Node<T>> nodes;
	private ArrayList<ArrayList<Edge<T>>> edges;
	private ArrayList<ArrayList<Node<T>>> adj;
	
	private Node<T> start;
	private Node<T> end;
	
	
	/* CONSTRUCTORS */
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj) {
		this.edges = new ArrayList<ArrayList<Edge<T>>>();;
		for (int i = 0; i < adj.size(); i++) {
			this.edges.add(new ArrayList<Edge<T>>());
			for (int j = 0; j < adj.get(i).size(); j++)
				this.edges.get(i).add(new Edge<T>(nodes.get(i), nodes.get(adj.get(i).get(j).index), 1));
		}
		this.nodes = nodes;
		this.adj = adj;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj, ArrayList<ArrayList<Edge<T>>> edges) {
		this.nodes = nodes;
		this.adj = adj;
		this.edges = edges;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj, ArrayList<ArrayList<Edge<T>>> edges, Node<T> start, Node<T> end) {
		this.nodes = nodes;
		this.adj = adj;
		this.edges = edges;
		this.start = start;
		this.end = end;
	}
	
	
	/* ACCESSOR METHODS */
	public ArrayList<ArrayList<Node<T>>> getAdjacencyList() {
		return this.adj;
	}
	public ArrayList<ArrayList<Edge<T>>> getEdges() {
		return this.edges;
	}
	public Node<T> getStart() {
		return this.start;
	}
	public Node<T> getEnd() {
		return this.end;
	}
	public ArrayList<Node<T>> getNodes() {
		return this.nodes;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		String adj_str = "adj: ";
		for (ArrayList<Node<T>> node : this.adj)
			adj_str += node;
		String weights_str = "wgt: ";
		for (ArrayList<Edge<T>> row : this.edges)
			weights_str += row;
		return adj_str + "\n" + weights_str;
	}
}
