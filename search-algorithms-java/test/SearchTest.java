import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 06.12.22
 * 
 * Here tests will be added for every new search algorithm implemented.
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SearchTest {
	
	
	/* tests with unweighted graphs */
	
	@Test
	public void testReachableDFSrec() {
		ArrayList<ArrayList<Node<Integer>>> data = createArrayList();
		ArrayList<Node<Integer>> nodes = data.remove(0);
		ArrayList<Node<Integer>> start_end = data.remove(0);
		Searcher_unweighted searcher = new Searcher_unweighted(nodes, data);
		
		Node<Integer> start = start_end.get(0);
		Node<Integer> end = start_end.get(1);
		assertEquals(true, searcher.reachableDFSrec(start, end));
		assertEquals(false, searcher.reachableDFSrec(end, start));
	}
	@Test
	public void testReachableDFSit() {
		ArrayList<ArrayList<Node<Integer>>> data = createArrayList();
		ArrayList<Node<Integer>> nodes = data.remove(0);
		ArrayList<Node<Integer>> start_end = data.remove(0);
		Searcher_unweighted searcher = new Searcher_unweighted(nodes, data);
		
		Node<Integer> start = start_end.get(0);
		Node<Integer> end = start_end.get(1);
		assertEquals(true, searcher.reachableDFSit(start, end));
		assertEquals(false, searcher.reachableDFSit(end, start));
	}
	@Test
	public void testReachableBFSrec() {
		ArrayList<ArrayList<Node<Integer>>> data = createArrayList();
		ArrayList<Node<Integer>> nodes = data.remove(0);
		ArrayList<Node<Integer>> start_end = data.remove(0);
		Searcher_unweighted searcher = new Searcher_unweighted(nodes, data);
		
		Node<Integer> start = start_end.get(0);
		Node<Integer> end = start_end.get(1);
		assertEquals(true, searcher.reachableBFSrec(start, end));
		assertEquals(false, searcher.reachableBFSrec(end, start));
	}
	@Test
	public void testReachableBFSit() {
		ArrayList<ArrayList<Node<Integer>>> data = createArrayList();
		ArrayList<Node<Integer>> nodes = data.remove(0);
		ArrayList<Node<Integer>> start_end = data.remove(0);
		Searcher_unweighted searcher = new Searcher_unweighted(nodes, data);
		
		Node<Integer> start = start_end.get(0);
		Node<Integer> end = start_end.get(1);
		assertEquals(true, searcher.reachableBFSit(start, end));
		assertEquals(false, searcher.reachableBFSit(end, start));
	}
	@Test
	public void testShortestPathBFSit() {
		ArrayList<ArrayList<Node<Integer>>> data = createArrayList();
		ArrayList<Node<Integer>> nodes = data.remove(0);
		ArrayList<Node<Integer>> start_end = data.remove(0);
		Searcher_unweighted searcher = new Searcher_unweighted(nodes, data);
		
		Node<Integer> start = start_end.get(0);
		Node<Integer> end = start_end.get(1);
		assertEquals(true, searcher.shortestPathBFSit(start, end) == 3);
	}
	
	
	/* tests with weighted graphs */
	
	@Test
	public void testDijkstra() {
		Graph<Integer> graph = createGraph(false);
		Searcher_weighted searcher = new Searcher_weighted(graph);
		Node<Integer> start = graph.getStart();
		
		int[] distances = searcher.dijkstra(start);
		int[] correct = new int[] {0, 2, 0, 1, 2};
		assertEquals(true, Arrays.equals(distances, correct));
	}
	@Test
	public void testBellmanFord() {
		Graph<Integer> graph1 = createGraph(false);
		Searcher_weighted searcher1 = new Searcher_weighted(graph1);
		Node<Integer> start = graph1.getStart();
		
		int[] distances1 = searcher1.bellmanford(start);
		int[] correct1 = new int[] {0, 2, 0, 1, 2};
		assertEquals(true, Arrays.equals(distances1, correct1));
		
		Graph<Integer> graph2 = createGraph(true);
		Searcher_weighted searcher2 = new Searcher_weighted(graph2);
		
		int[] distances2 = searcher2.bellmanford(start);
		int[] correct2 = new int[] {0, -4, 0, -2, -3};
		assertEquals(true, Arrays.equals(distances2, correct2));
	}
	@Test
	public void testBoruvka() {
		Graph<Integer> graph1 = createGraph(false);
		Searcher_weighted searcher1 = new Searcher_weighted(graph1);
		for (ArrayList<Edge<Integer>> edges : graph1.getEdges()) {
			for (Edge<Integer> edge : edges) {
				if (edge.getCost() == 0)
					continue;
				System.out.println(edge);
			}
		}
		
		Graph MST1 = searcher1.Boruvka();
		System.out.println(MST1);
		System.out.println(MST1.getTotalCost());
		assertEquals(5, MST1.getTotalCost());
	}
	
	public ArrayList<ArrayList<Node<Integer>>> createArrayList() {
		Node.setId(0);
		
		ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>();
		/*
		 *  this array (data) contains the information needed to store an unweighted graph:
		 *  - Array containing all nodes
		 *  - Array containing start and end node
		 *  - all the following entries make up the adjacency array
		 */
		ArrayList<ArrayList<Node<Integer>>> data = new ArrayList<ArrayList<Node<Integer>>>();
		for (int i = 0; i < 9; i++)
			data.add(new ArrayList<>());
		
		Node<Integer> node_0 = new Node<Integer>(0);
		Node<Integer> node_1 = new Node<Integer>(1);
		Node<Integer> node_2 = new Node<Integer>(2);
		Node<Integer> node_3 = new Node<Integer>(3);
		Node<Integer> node_4 = new Node<Integer>(4);
		Node<Integer> node_5 = new Node<Integer>(5);
		Node<Integer> node_6 = new Node<Integer>(6);
		nodes.add(node_0);
		nodes.add(node_1);
		nodes.add(node_2);
		nodes.add(node_3);
		nodes.add(node_4);
		nodes.add(node_5);
		nodes.add(node_6);
		data.set(0, nodes);
		
		data.get(1).add(node_0);
		data.get(1).add(node_6);
		
		data.get(2).add(node_3);
		data.get(3).add(node_0);
		data.get(3).add(node_3);
		data.get(4).add(node_1);
		data.get(4).add(node_4);
		data.get(5).add(node_5);
		data.get(6).add(node_3);
		data.get(7).add(node_6);
		
		return data;
	}
	public Graph createGraph(boolean negativeWeightsAllowed) {
		/* 
		 * creates a weighted graph with
		 * positive (and, if allowed, negative) edge-costs and no cycles
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
		node_4_adj.add(node_2);
		adjacencyList.add(node_0_adj);
		adjacencyList.add(node_1_adj);
		adjacencyList.add(node_2_adj);
		adjacencyList.add(node_3_adj);
		adjacencyList.add(node_4_adj);
		
		ArrayList<ArrayList<Edge<Integer>>> edges = new ArrayList<>();
		edges.add(new ArrayList<>());
		edges.get(0).add(new Edge<Integer>(node_0, node_0, 0));
		edges.get(0).add(new Edge<Integer>(node_0, node_1, (negativeWeightsAllowed)? -4 : 4));
		edges.get(0).add(new Edge<Integer>(node_0, node_2, 0));
		edges.get(0).add(new Edge<Integer>(node_0, node_3, (negativeWeightsAllowed)? -1 : 1));
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
		edges.get(2).add(new Edge<Integer>(node_2, node_3, (negativeWeightsAllowed)? -2 : 2));
		edges.get(2).add(new Edge<Integer>(node_2, node_4, 0));
		edges.add(new ArrayList<>());
		edges.get(3).add(new Edge<Integer>(node_3, node_0, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_1, 1));
		edges.get(3).add(new Edge<Integer>(node_3, node_2, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_3, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_4, (negativeWeightsAllowed)? -1 : 1));
		edges.add(new ArrayList<>());
		edges.get(4).add(new Edge<Integer>(node_4, node_0, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_1, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_2, 3));
		edges.get(4).add(new Edge<Integer>(node_4, node_3, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_4, 0));
				
		return new Graph(nodes, adjacencyList, edges, node_0, node_4);
	}
}
