import java.util.ArrayList;
import java.util.Arrays;

public class Graph<T extends Comparable<T>> {
	private ArrayList<ArrayList<Node<T>>> adj;
	private ArrayList<Integer> weights;
	
	public Graph(ArrayList<ArrayList<Node<T>>> adj) {
		Integer[] weights = new Integer[adj.size()];
		Arrays.fill(weights, 1);
		this.adj = adj;
		this.weights = new ArrayList<Integer>(Arrays.asList(weights));
	}
	public Graph(ArrayList<ArrayList<Node<T>>> adj, Integer[] weights) {
		this.adj = adj;
		this.weights = new ArrayList<Integer>(Arrays.asList(weights));
	}
	
	/* accessor methods */
	public ArrayList<ArrayList<Node<T>>> getAdjacencyList() {
		return this.adj;
	}
	public ArrayList<Integer> getWeights() {
		return this.weights;
	}
	
	public String toString() {
		String adj_str = "adj: ";
		for (ArrayList<Node<T>> node : this.adj)
			adj_str += node;
		String weights_str = "" + this.weights;
		return adj_str + "\nwgt: " + weights_str;
	}
}
