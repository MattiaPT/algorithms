import java.util.ArrayList;
import java.util.Arrays;

public class Searcher_weighted {
	Graph G;
	
	public Searcher_weighted(Graph G) {
		this.G = G;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Searcher_weighted(ArrayList<Node<Integer>> nodes, ArrayList<ArrayList<Integer>> adj, Edge<Integer>[][] edges) {
		this.G = new Graph(nodes, adj, edges);
	}
	
	/* shortest path tree using Dijkstra */
	@SuppressWarnings("unchecked")
	public int[] dijkstra(Node<Integer> start) {
		ArrayList<ArrayList<Node<Integer>>> adj = G.getAdjacencyList();
		Edge<Integer>[][] edges = G.getEdges();
		int[] d = new int[adj.size()];
		for (int i = 0; i < d.length; i++)
			d[i] = (i == start.index)? 0: Integer.MAX_VALUE;
		
		Heap<Node<Integer>> H = new Heap<Node<Integer>>(G.getNodes(), false);
		ArrayList<Node<Integer>> S = new ArrayList<>();
		
		decreaseKey(H, start, 0);
		System.out.println(H);
		System.out.println(S);
		System.out.println(Arrays.toString(d));
		while (S.size() != adj.size()) {
			Node<Integer> v = H.removeFirst();
			S.add(v);
			for (int i = 0; i < adj.get(v.index).size(); i++) {
				if (S.contains(adj.get(v.index).get(i)))
					continue;
				d[adj.get(v.index).get(i).index] = Math.min(d[adj.get(v.index).get(i).index], d[v.index] + edges[adj.get(v.index).get(i).index][v.index].cost);
				decreaseKey(H, S.get(adj.get(v.index).get(i).index), d[adj.get(v.index).get(i).index]);
			}
		}
		return d;
	}
	public void decreaseKey(Heap<Node<Integer>> Heap, Node<Integer> ptr, int value) {
		ptr.value = value;
		Heap.restoreHeapCondition();
	}
}
