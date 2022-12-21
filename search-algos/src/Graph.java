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
	public Graph() {}
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
	
	
	public void addEdge(Node<T> start, Node<T> end, int cost) {
		if (edges == null) edges = new ArrayList<ArrayList<Edge<T>>>();
		if (adjacencyList == null) adjacencyList = new ArrayList<ArrayList<Node<T>>>();
		while (true) {
			try { edges.get(start.getIndex()); break; }
			catch (Exception e) { edges.add(new ArrayList<Edge<T>>()); }
		}
		while (true) {
			try { edges.get(start.getIndex()).get(end.getIndex()); break; }
			catch (Exception e) { edges.get(start.getIndex()).add(new Edge<T>()); }
		}
		edges.get(start.getIndex()).set(end.getIndex(), new Edge<T>(start, end, cost));
		
		while (true) {
			try { adjacencyList.get(start.getIndex()); break; }
			catch (Exception e) { adjacencyList.add(new ArrayList<Node<T>>()); }
		}
		adjacencyList.get(start.getIndex()).add(end);
	}
	
	public ArrayList<ArrayList<Node<Integer>>> getZHKs() {
		ArrayList<ArrayList<Node<Integer>>> ZHKs = new ArrayList<ArrayList<Node<Integer>>>();
		ZHKs.add(new ArrayList<Node<Integer>>());
		ZHKs.get(0).add((Node<Integer>) nodes.get(0));
		Searcher_unweighted searcher = new Searcher_unweighted(this);
		
		int index = 0;
		for (int i = 0; i < nodes.size(); i++) {
			Node<Integer> node = (Node<Integer>) nodes.get(i);
			if (searcher.reachableBFSit(ZHKs.get(index).get(0), (Node<Integer>) nodes.get(i))) {
				ZHKs.get(index).add((Node<Integer>) nodes.get(i));
				continue;
			}
			index++;
			ZHKs.add(new ArrayList<Node<Integer>>());
			ZHKs.get(index).add((Node<Integer>) nodes.get(i));
		}
		return ZHKs;
	}
	
	/* MUTATOR METHODS */
	public void setNodes(ArrayList<Node<T>> nodes) {
		this.nodes = nodes;
	}
	public void setEdges(ArrayList<ArrayList<Edge<T>>> edges) {
		this.edges = edges;
	}
	public void setAdjacencyList(ArrayList<ArrayList<Node<T>>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	/* ACCESSOR METHODS */
	public ArrayList<Node<T>> getNodes() {
		return nodes;
	}
	public ArrayList<ArrayList<Edge<T>>> getEdges() {
		return edges;
	}
	public ArrayList<ArrayList<Node<T>>> getAdjacencyList() {
		return adjacencyList;
	}
	public Node<T> getStart() {
		return start;
	}
	public Node<T> getEnd() {
		return end;
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
