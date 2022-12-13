import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class SearchTest {
	
	
	/* test with unweighted graphs */
	
	@Test
	public void testReachableDFSrec() {
		Node<Integer> node_0 = new Node<Integer>(0);
		Node<Integer> node_6 = new Node<Integer>(6);
		Searcher_unweighted s = new Searcher_unweighted(createArrayList(node_0, node_6));	
	}
	@Test
	public void testReachableDFSit() {
		Node<Integer> node_0 = new Node<Integer>(0);
		Node<Integer> node_6 = new Node<Integer>(6);
		Searcher_unweighted s = new Searcher_unweighted(createArrayList(node_0, node_6));	
		
	}
	@Test
	public void testReachableBFSrec() {
		Node<Integer> node_0 = new Node<Integer>(0);
		Node<Integer> node_6 = new Node<Integer>(6);
		Searcher_unweighted s = new Searcher_unweighted(createArrayList(node_0, node_6));	
		
	}
	@Test
	public void testReachableBFSit() {
		Node<Integer> node_0 = new Node<Integer>(0);
		Node<Integer> node_6 = new Node<Integer>(6);
		Searcher_unweighted s = new Searcher_unweighted(createArrayList(node_0, node_6));	
		
	}
	
	
	/* tests with weighted graphs */
	
	@Test
	public void testDijkstra() {
		Searcher_weighted s = new Searcher_weighted(createGraph());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<ArrayList<Node<Integer>>> createArrayList(Node node_0, Node node_6) {
		ArrayList<ArrayList<Node<Integer>>> n = new ArrayList<ArrayList<Node<Integer>>>();
		
		for (int i = 0; i < 8; i++)
			n.add(new ArrayList<>());
		
		
		Node<Integer> node_1 = new Node<Integer>(1);
		Node<Integer> node_3 = new Node<Integer>(3);
		Node<Integer> node_4 = new Node<Integer>(4);
		Node<Integer> node_5 = new Node<Integer>(5);
		n.get(0).add(node_3);
		n.get(1).add(node_0);
		n.get(1).add(node_3);
		n.get(2).add(node_1);
		n.get(2).add(node_4);
		n.get(3).add(node_5);
		n.get(4).add(node_3);
		n.get(4).add(node_6);
		n.get(5).add(node_6);
		n.get(7).add(node_4);
		
		return n;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
