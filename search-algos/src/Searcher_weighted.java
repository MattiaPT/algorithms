import java.util.ArrayList;
import java.util.Arrays;

public class Searcher_weighted {
	Graph G;
	
	public Searcher_weighted(ArrayList<ArrayList<Integer>> adj, Integer[] weights) {
		this.G = new Graph(adj, weights);
	}
	
	/* shortest path tree using Dijkstra */
	public int[] Dijkstra(int start) {
		ArrayList<ArrayList<Integer>> adj = G.getAdjacencyList();
		ArrayList<Integer> weights = G.getWeights();
		int[] d = new int[adj.size()];
		for (int i = 0; i < d.length; i++)
			d[i] = (i == start)? 0: Integer.MAX_VALUE;
		int[] elements = {10, 3, 2, 5, 123, 5};
		@SuppressWarnings("unchecked")
		Node<Integer>[] nodes = new Node[elements.length];
		for (int i = 0; i < elements.length; i++)
			nodes[i] = new Node<Integer>(elements[i]);
		
		Heap<Node<Integer>> H = new Heap<Node<Integer>>(nodes, false);
		ArrayList<Node<Integer>> S = new ArrayList<>(Arrays.asList(nodes));
		
		System.out.println("CHECKPOINT");
		while (S.size() != adj.size()) {
			Node<Integer> v = H.removeFirst();
			S.add(v);
			for (int i = 0; i < adj.get(v.value).size(); i++) {
				if (S.contains(adj.get(v.value).get(i)))
					continue;
				d[adj.get(v.value).get(i)] = Math.min(d[adj.get(v.value).get(i)], d[v.value] + weights[adj.get(v.value).get(i)][v.value]);
				decreaseKey(H, S.get(adj.get(v.value).get(i)), d[adj.get(v.value).get(i)]);
			}
		}
		return d;
	}
	public void decreaseKey(Heap<Node<Integer>> Heap, Node<Integer> ptr, int value) {
		ptr.value = value;
		Heap.restoreHeapCondition();
	}
}
