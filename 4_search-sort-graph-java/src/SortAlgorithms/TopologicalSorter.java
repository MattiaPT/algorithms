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
		ArrayList<Edge> edges = graph.getEdges();
		
		int[] order = new int[nodes.size()];
		
		int[] degIn = new int[nodes.size()];
		for (Edge edge : edges)
			degIn[edge.getEnd().getIndex()]++;
		for (Node node : nodes) {
			if (degIn[node.getIndex()] == 0)
				stack.push(node);
		}
		
		int i = 0;
		while (!stack.isEmpty()) {
			Node v = (Node) stack.pop();
			order[v.getIndex()] = i++;
			for (Edge edge : edges) {
				if (!edge.getStart().equals(v))
					continue;
				degIn[edge.getEnd().getIndex()]--;
				if (degIn[edge.getEnd().getIndex()] == 0)
					stack.push(edge.getEnd());
			}
		}
		
		return order;
	}
}
