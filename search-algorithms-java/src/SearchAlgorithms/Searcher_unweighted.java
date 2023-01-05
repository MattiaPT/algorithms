package SearchAlgorithms;
import java.util.ArrayList;
import java.util.Stack;

import GraphTheory.*;

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
	public Searcher_unweighted(ArrayList<GraphTheory.Node<Integer>> nodes, ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList) {
		graph = new Graph(nodes, adjacencyList);
	}
	public Searcher_unweighted(Graph graph) {
		this.graph = graph;
	}
	

	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(GraphTheory.Node<Integer> start, GraphTheory.Node<Integer> end) {
		boolean[] visited = new boolean[graph.getNodes().size()];
		return reachableDFSrec(start, end, visited);
	}
	public boolean reachableDFSrec(GraphTheory.Node<Integer> current, GraphTheory.Node<Integer> end, boolean[] visited) {
		visited[current.getIndex()] = true;
		if (current.getIndex() == end.getIndex())
			return true;
		boolean foundEnd = false;
		ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		for (GraphTheory.Node<Integer> neighbour : adjacencyList.get(current.getIndex()))
			foundEnd = foundEnd || (!visited[neighbour.getIndex()] && reachableDFSrec(neighbour, end, visited));
		return foundEnd;
	}
	/* iteratively */
	public boolean reachableDFSit(GraphTheory.Node<Integer> start, GraphTheory.Node<Integer> end) {
		Stack<GraphTheory.Node<Integer>> stack = new Stack<GraphTheory.Node<Integer>>();
		ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		boolean[] visited = new boolean[graph.getNodes().size()];
		stack.push(start);
		while (stack.size() != 0) {
			GraphTheory.Node<Integer> current = stack.pop();
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
	public boolean reachableBFSrec(GraphTheory.Node<Integer> start, GraphTheory.Node<Integer> end) {
		Queue<GraphTheory.Node<Integer>> queue = new LinkedList<GraphTheory.Node<Integer>>();
		boolean[] visited = new boolean[graph.getNodes().size()];
		queue.add(start);
		return helperReachableBFSrec(queue, end, visited);
	}
	public boolean helperReachableBFSrec(Queue<GraphTheory.Node<Integer>> queue, GraphTheory.Node<Integer> end, boolean[] visited) {
		if (queue.isEmpty())
			return false;
		GraphTheory.Node<Integer> current = queue.remove();
		visited[current.getIndex()] = true;
		if (current.getIndex() == end.getIndex())
			return true;
		ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
			if (!visited[adjacencyList.get(current.getIndex()).get(i).getIndex()])
				queue.add(adjacencyList.get(current.getIndex()).get(i));
		}
		return helperReachableBFSrec(queue, end, visited);
	}
	/* iteratively */
	public boolean reachableBFSit(GraphTheory.Node<Integer> start, GraphTheory.Node<Integer> end) {
		Queue<GraphTheory.Node<Integer>> queue = new LinkedList<GraphTheory.Node<Integer>>();
		ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		if (adjacencyList.isEmpty()) return false;
		boolean[] visited = new boolean[graph.getNodes().size()];
		queue.add(start);
		while (!queue.isEmpty()) {
			GraphTheory.Node<Integer> current = queue.remove();
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
	public int shortestPathBFSit(GraphTheory.Node<Integer> start, GraphTheory.Node<Integer> end) {
		Queue<GraphTheory.Node<Integer>> queue = new LinkedList<GraphTheory.Node<Integer>>();
		Queue<Integer> distances = new LinkedList<Integer>();
		ArrayList<ArrayList<GraphTheory.Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		boolean[] visited = new boolean[graph.getNodes().size()];
		
		queue.add(start);
		distances.add(0);
		while (!queue.isEmpty()) {
			GraphTheory.Node<Integer> current = queue.remove();
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
