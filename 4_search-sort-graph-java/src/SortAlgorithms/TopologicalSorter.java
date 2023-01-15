package SortAlgorithms;

import GraphTheory.*;
import java.util.Stack;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class TopologicalSorter {
	Graph graph;
	
	/* CONSTRUCTORS */
	public TopologicalSorter(Graph graph) {
		this.graph = graph;
	}
	
	public int[] getTopologicalOrdering() {
		Stack stack = new Stack();
		
		ArrayList<Node> nodes = graph.getNodes();
		ArrayList<ArrayList<Node>> adjacencyList = graph.getAdjacencyList();
		
		int[] order = new int[nodes.size()];
		
		int[] degIn = new int[nodes.size()];
		for (ArrayList<Node> arr : adjacencyList) {
			for (Node node : arr)
				degIn[node.getIndex()]++;
		}
			
		for (Node node : nodes) {
			if (degIn[node.getIndex()] == 0)
				stack.push(node);
		}
		
		int i = 0;
		while (!stack.isEmpty()) {
			Node v = (Node) stack.pop();
			order[v.getIndex()] = i++;
			for (Node node : adjacencyList.get(v.getIndex())) {
				degIn[node.getIndex()]--;
				if (degIn[node.getIndex()] == 0)
					stack.push(node);
			}
			adjacencyList.set(v.getIndex(), new ArrayList<Node>());
		}
		
		return order;
	}
}
