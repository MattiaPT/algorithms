import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class SearchTest {
	
	
	/* test with unweighted graphs */
	
	@Test
	public void testReachableDFSrec() {
		Searcher_unweighted s = new Searcher_unweighted(createArrayList());
		
		assertEquals(true, s.reachableDFSrec(7, 6));
		assertEquals(false, s.reachableDFSrec(6, 7));
		
		assertEquals(true, s.reachableDFSrec(0, 6));
		assertEquals(false, s.reachableDFSrec(0, 1));
		
	}
	@Test
	public void testReachableDFSit() {
		Searcher_unweighted s = new Searcher_unweighted(createArrayList());
		
		assertEquals(true, s.reachableDFSit(7, 6));
		assertEquals(false, s.reachableDFSit(6, 7));
		
		assertEquals(true, s.reachableDFSit(0, 6));
		assertEquals(false, s.reachableDFSit(0, 1));
		
	}
	@Test
	public void testReachableBFSrec() {
		Searcher_unweighted s = new Searcher_unweighted(createArrayList());
		
		assertEquals(true, s.reachableBFSrec(7, 6));
		assertEquals(false, s.reachableBFSrec(6, 7));
		
		assertEquals(true, s.reachableBFSrec(0, 6));
		assertEquals(false, s.reachableBFSrec(0, 1));
		
	}
	@Test
	public void testReachableBFSit() {
		Searcher_unweighted s = new Searcher_unweighted(createArrayList());
		
		assertEquals(true, s.reachableBFSit(7, 6));
		assertEquals(false, s.reachableBFSit(6, 7));
		
		assertEquals(true, s.reachableBFSit(0, 6));
		assertEquals(false, s.reachableBFSit(0, 1));
		
	}
	
	
	/* tests with weighted graphs */
	
	@Test
	public void testDijkstra() {
		Searcher_weighted s = new Searcher_weighted(createGraph());
	}
	
	public ArrayList<ArrayList<Integer>> createArrayList() {
		ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < 8; i++)
			n.add(new ArrayList<>());
		
		n.get(0).add(3);
		n.get(1).add(0);
		n.get(1).add(3);
		n.get(2).add(1);
		n.get(2).add(4);
		n.get(3).add(5);
		n.get(4).add(3);
		n.get(4).add(6);
		n.get(5).add(6);
		n.get(7).add(4);
		
		return n;
	}
	public Graph createGraph() {
		ArrayList<ArrayList<Node<Integer>>> adj = new ArrayList<ArrayList<Node<Integer>>>();
		ArrayList<Node<Integer>> node_1_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_2_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_3_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_4_adj = new ArrayList<Node<Integer>>();
		ArrayList<Node<Integer>> node_5_adj = new ArrayList<Node<Integer>>();
		Node<Integer> node_1 = new Node(0);
		Node<Integer> node_2 = new Node(1);
		Node<Integer> node_3 = new Node(2);
		Node<Integer> node_4 = new Node(3);
		Node<Integer> node_5 = new Node(4);
		node_1_adj.add(node_2);
		node_1_adj.add(node_3);
		node_1_adj.add(node_5);
		node_2_adj.add(node_5);
		node_3_adj.add(node_4);
		node_4_adj.add(node_5);
		node_5_adj.add(node_3);
		
		Integer[][] weights = new Integer[adj.size()][adj.size()];
		weights[0] = new Integer[] {0, 4, 2, 0, 18};
		weights[1] = new Integer[] {0, 0, 0, 0, 1};
		weights[2] = new Integer[] {0, 0, 0, 1, 0};
		weights[3] = new Integer[] {0, 0, 0, 0, 1};
		weights[4] = new Integer[] {0, 0, 1, 0, 0};
		
		
		return new Graph(adj, weights);
	}
}
