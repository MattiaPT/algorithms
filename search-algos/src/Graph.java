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
	private ArrayList<ArrayList<Node<T>>> adjacencyList;
	
	private Node<T> start;
	private Node<T> end;
	
	
	/* CONSTRUCTORS */
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adjacencyList) {
		edges = new ArrayList<ArrayList<Edge<T>>>();;
		for (int i = 0; i < adjacencyList.size(); i++) {
			edges.add(new ArrayList<Edge<T>>());
			for (int j = 0; j < adjacencyList.get(i).size(); j++)
				edges.get(i).add(new Edge<T>(nodes.get(i), nodes.get(adjacencyList.get(i).get(j).getIndex()), 1));
		}
		this.nodes = nodes;
		this.adjacencyList = adjacencyList;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adjacencyList, ArrayList<ArrayList<Edge<T>>> edges) {
		this.nodes = nodes;
		this.adjacencyList = adjacencyList;
		this.edges = edges;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adjacencyList, ArrayList<ArrayList<Edge<T>>> edges, Node<T> start, Node<T> end) {
		this.nodes = nodes;
		this.adjacencyList = adjacencyList;
		this.edges = edges;
		this.start = start;
		this.end = end;
	}
	
	
	/* ACCESSOR METHODS */
	public ArrayList<ArrayList<Node<T>>> getAdjacencyList() {
		return adjacencyList;
	}
	public ArrayList<ArrayList<Edge<T>>> getEdges() {
		return edges;
	}
	public Node<T> getStart() {
		return start;
	}
	public Node<T> getEnd() {
		return end;
	}
	public ArrayList<Node<T>> getNodes() {
		return nodes;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		String adj_str = "adj: ";
		for (ArrayList<Node<T>> node : adjacencyList)
			adj_str += node;
		String weights_str = "wgt: ";
		for (ArrayList<Edge<T>> row : edges)
			weights_str += row;
		return adj_str + "\n" + weights_str;
	}
}
