import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
	private ArrayList<Node<T>> nodes;
	private ArrayList<ArrayList<Edge<T>>> edges;
	private ArrayList<ArrayList<Node<T>>> adj;
	
	private Node<T> start;
	private Node<T> end;
	
	@SuppressWarnings("unchecked")
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj) {
		this.edges = new ArrayList<ArrayList<Edge<T>>>();;
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++)
				this.edges.get(i).set(adj.get(i).get(j).index, new Edge<T>(nodes.get(i), nodes.get(adj.get(i).get(j).index), 1));
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
	
	/* accessor methods */
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
