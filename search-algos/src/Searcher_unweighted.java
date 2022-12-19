import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Author: Mattia
 * Date: 13.12.22
 * 
 * All algorithms on unweighted graphs are
 * being implemented in this class.
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Searcher_unweighted {
	Graph graph;
	
	
	/* CONSTRUCTORS */
	public Searcher_unweighted(ArrayList<Node<Integer>> nodes, ArrayList<ArrayList<Node<Integer>>> adjacencyList) {
		graph = new Graph(nodes, adjacencyList);
	}
	public Searcher_unweighted(Graph graph) {
		this.graph = graph;
	}
	

	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(Node<Integer> start, Node<Integer> end) {
		boolean[] visited = new boolean[graph.getNodes().size()];
		return reachableDFSrec(start, end, visited);
	}
	public boolean reachableDFSrec(Node<Integer> current, Node<Integer> end, boolean[] visited) {
		visited[current.getIndex()] = true;
		if (current.getIndex() == end.getIndex())
			return true;
		boolean foundEnd = false;
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		for (Node<Integer> neighbour : adjacencyList.get(current.getIndex()))
			foundEnd = foundEnd || (!visited[neighbour.getIndex()] && reachableDFSrec(neighbour, end, visited));
		return foundEnd;
	}
	/* iteratively */
	public boolean reachableDFSit(Node<Integer> start, Node<Integer> end) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		boolean[] visited = new boolean[graph.getNodes().size()];
		stack.push(start);
		while (stack.size() != 0) {
			Node<Integer> current = stack.pop();
			visited[current.getIndex()] = true;
			if (current.getIndex() == end.getIndex())
				return true;
			for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
				if (!visited[adjacencyList.get(current.getIndex()).get(i).getIndex()])
					stack.push(adjacencyList.get(current.getIndex()).get(i));
			}
		}
		return false;
	}
	
	
	/* tests reachability of y from start x using BFS */
	/* recursively */
	public boolean reachableBFSrec(Node<Integer> start, Node<Integer> end) {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		boolean[] visited = new boolean[graph.getNodes().size()];
		queue.add(start);
		return helperReachableBFSrec(queue, end, visited);
	}
	public boolean helperReachableBFSrec(Queue<Node<Integer>> queue, Node<Integer> end, boolean[] visited) {
		if (queue.isEmpty())
			return false;
		Node<Integer> current = queue.remove();
		visited[current.getIndex()] = true;
		if (current.getIndex() == end.getIndex())
			return true;
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
			if (!visited[adjacencyList.get(current.getIndex()).get(i).getIndex()])
				queue.add(adjacencyList.get(current.getIndex()).get(i));
		}
		return helperReachableBFSrec(queue, end, visited);
	}
	/* iteratively */
	public boolean reachableBFSit(Node<Integer> start, Node<Integer> end) {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		if (adjacencyList.isEmpty()) return false;
		boolean[] visited = new boolean[graph.getNodes().size()];
		queue.add(start);
		while (!queue.isEmpty()) {
			Node<Integer> current = queue.remove();
			visited[current.getIndex()] = true;
			if (current.getIndex() == end.getIndex())
				return true;
			for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
				if (!visited[adjacencyList.get(current.getIndex()).get(i).getIndex()])
					queue.add(adjacencyList.get(current.getIndex()).get(i));
			}
		}
		return false;
	}
	
	
	/* get shortest path from x to y in a graph with unweighted edges using BFS */
	/* iteratively */
	public int shortestPathBFSit(Node<Integer> start, Node<Integer> end) {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		Queue<Integer> distances = new LinkedList<Integer>();
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		boolean[] visited = new boolean[graph.getNodes().size()];
		
		queue.add(start);
		distances.add(0);
		while (!queue.isEmpty()) {
			Node<Integer> current = queue.remove();
			if (current.getIndex() == end.getIndex())
				return distances.remove();
			int distance = distances.remove();
			visited[current.getIndex()] = true;
			for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
				if (!visited[adjacencyList.get(current.getIndex()).get(i).getIndex()]) {
					queue.add(adjacencyList.get(current.getIndex()).get(i));
					distances.add(distance + 1);
				}
			}
		}
		return -1;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		return graph + "";
	}
}
