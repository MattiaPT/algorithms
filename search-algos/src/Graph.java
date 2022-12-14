import java.util.ArrayList;
import java.util.Arrays;

public class Graph<T extends Comparable<T>> {
	private ArrayList<Node<T>> nodes;
	private ArrayList<ArrayList<Node<T>>> adj;
	private Integer[][] weights;
	
	private Node<T> start;
	private Node<T> end;
	
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj) {
		Integer[][] weights = new Integer[adj.size()][adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++)
				weights[i][adj.get(i).get(j).index] = 1;
		}
		this.nodes = nodes;
		this.adj = adj;
		this.weights = weights;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj, Integer[][] weights) {
		this.nodes = nodes;
		this.adj = adj;
		this.weights = weights;
	}
	public Graph(ArrayList<Node<T>> nodes, ArrayList<ArrayList<Node<T>>> adj, Integer[][] weights, Node<T> start, Node<T> end) {
		this.nodes = nodes;
		this.adj = adj;
		this.weights = weights;
		this.start = start;
		this.end = end;
	}
	
	/* accessor methods */
	public ArrayList<ArrayList<Node<T>>> getAdjacencyList() {
		return this.adj;
	}
	public Integer[][] getWeights() {
		return this.weights;
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
		for (Integer[] row : this.weights)
			weights_str += row;
		return adj_str + "\n" + weights_str;
	}
}
