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
		Graph<Integer> graph = createGraph1();
		Searcher_weighted searcher = new Searcher_weighted(graph);
		
		Node<Integer> start = graph.getStart();
		
		int[] distances = searcher.dijkstra(start);
		int[] correct = new int[] {0, 4, 2, 3, 4};
		assertEquals(true, Arrays.equals(distances, correct));
	}
	@Test
	public void testBellmanFord() {
		Graph<Integer> graph = createGraph1();
		Searcher_weighted searcher = new Searcher_weighted(graph);
		
		Node<Integer> start = graph.getStart();
		
		int[] distances = searcher.bellmanford(start);
		int[] correct = new int[] {0, 4, 2, 3, 4};
		assertEquals(true, Arrays.equals(distances, correct));
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
	public Graph createGraph1() {
		/* 
		 * creates a weighted graph with non-negative 
		 * edge-costs and no cycles
		 */
		
		Node.setId(0);
		
		ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>();
		ArrayList<ArrayList<Node<Integer>>> adj = new ArrayList<ArrayList<Node<Integer>>>();
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
		node_0_adj.add(node_4);
		node_1_adj.add(node_4);
		node_2_adj.add(node_3);
		node_3_adj.add(node_4);
		node_4_adj.add(node_2);
		adj.add(node_0_adj);
		adj.add(node_1_adj);
		adj.add(node_2_adj);
		adj.add(node_3_adj);
		adj.add(node_4_adj);
		
		ArrayList<ArrayList<Edge<Integer>>> edges = new ArrayList<>();
		edges.add(new ArrayList<>());
		edges.get(0).add(new Edge<Integer>(node_0, node_0, 0));
		edges.get(0).add(new Edge<Integer>(node_0, node_1, 4));
		edges.get(0).add(new Edge<Integer>(node_0, node_2, 2));
		edges.get(0).add(new Edge<Integer>(node_0, node_3, 0));
		edges.get(0).add(new Edge<Integer>(node_0, node_4, 18));
		edges.add(new ArrayList<>());
		edges.get(1).add(new Edge<Integer>(node_1, node_0, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_1, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_2, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_3, 0));
		edges.get(1).add(new Edge<Integer>(node_1, node_4, 1));
		edges.add(new ArrayList<>());
		edges.get(2).add(new Edge<Integer>(node_2, node_0, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_1, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_2, 0));
		edges.get(2).add(new Edge<Integer>(node_2, node_3, 1));
		edges.get(2).add(new Edge<Integer>(node_2, node_4, 0));
		edges.add(new ArrayList<>());
		edges.get(3).add(new Edge<Integer>(node_3, node_0, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_1, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_2, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_3, 0));
		edges.get(3).add(new Edge<Integer>(node_3, node_4, 1));
		edges.add(new ArrayList<>());
		edges.get(4).add(new Edge<Integer>(node_4, node_0, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_1, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_2, 1));
		edges.get(4).add(new Edge<Integer>(node_4, node_3, 0));
		edges.get(4).add(new Edge<Integer>(node_4, node_4, 0));
				
		return new Graph(nodes, adj, edges, node_0, node_4);
	}
}
