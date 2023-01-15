import org.junit.Assert;

import java.util.ArrayList;

import org.junit.Test;

import GraphTheory.*;
import SortAlgorithms.TopologicalSorter;


public class SortTest {

	@Test
	public void testGetTopologicalOrdering() {
		TopologicalSorter test1 = new TopologicalSorter(createGraph());
		int[] solution = new int[] {0, 3, 1, 2, 4};
		Assert.assertArrayEquals(solution, test1.getTopologicalOrdering());
	}
	
	public Graph createGraph() {
		/* 
		 * creates a weighted graph with
		 * positive edge-costs and no cycles
		 */
		
		Node.setId(0);
		
		ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>();
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = new ArrayList<ArrayList<Node<Integer>>>();
		ArrayList<Node<Integer>> node_0_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_1_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_2_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_3_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_4_adj = new ArrayList<Node<Integer>>();
		Node<Integer> node_0 = new Node(0);
		Node<Integer> node_1 = new Node(1);
		Node<Integer> node_2 = new Node(2);
		Node<Integer> node_3 = new Node(3);
		Node<Integer> node_4 = new Node(4);
		nodes.add(node_0);
		nodes.add(node_1);
		nodes.add(node_2);
		nodes.add(node_3);
		nodes.add(node_4);
		node_0_adj.add(node_1);
		node_0_adj.add(node_2);
		node_0_adj.add(node_3);
		node_1_adj.add(node_4);
		node_2_adj.add(node_3);
		node_3_adj.add(node_4);
		node_3_adj.add(node_1);
		adjacencyList.add(node_0_adj);
		adjacencyList.add(node_1_adj);
		adjacencyList.add(node_2_adj);
		adjacencyList.add(node_3_adj);
		adjacencyList.add(node_4_adj);
		
		ArrayList<ArrayList<Edge<Integer>>> edges = new ArrayList<>();
		edges.add(new ArrayList<>());
		edges.get(0).add(new Edge<Integer>(node_0, node_0, 0));
		edges.get(0).add(new Edge<Integer>(node_0, node_1, 4));
		edges.get(0).add(new Edge<Integer>(node_0, node_2, 2));
		edges.get(0).add(new Edge<Integer>(node_0, node_3, 1));
		edges.get(0).add(new Edge<Integer>(node_0, node_4, 0));
		edges.add(new ArrayList<>());
		edges.get(1).add(new Edge<Integer>(node_1, node_0, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_1, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_2, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_3, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_4, 5));
		edges.add(new ArrayList<>());
		edges.get(2).add(new Edge<Integer>(node_2, node_0, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_1, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_2, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_3, 2));
		edges.get(2).add(new Edge<Integer>(node_2, node_4, 0));
		edges.add(new ArrayList<>());
		edges.get(3).add(new Edge<Integer>(node_3, node_0, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_1, 1));
		edges.get(3).add(new Edge<Integer>(node_3, node_2, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_3, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_4, 1));
		edges.add(new ArrayList<>());
		edges.get(4).add(new Edge<Integer>(node_4, node_0, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_1, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_2, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_3, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_4, 0));
		
		return new Graph(nodes, adjacencyList, edges);
	}
}
