import java.util.ArrayList;

/*
 * Author: Mattia
 * Date: 13.12.22
 * 
 * All algorithms on weighted graphs are
 * being implemented in this class.
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Searcher_weighted {
	Graph graph;
	
	
	/* CONSTRUCTORS */
	public Searcher_weighted(Graph graph) {
		this.graph = graph;
	}
	public Searcher_weighted(ArrayList<Node<Integer>> nodes, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<ArrayList<Edge<Integer>>> edges) {
		this.graph = new Graph(nodes, adjacencyList, edges);
	}
	
	/* shortest path tree using Dijkstra */
	public int[] dijkstra(Node<Integer> start) {
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		ArrayList<ArrayList<Edge<Integer>>> edges = graph.getEdges();
		int[] distances = new int[adjacencyList.size()];
		for (int i = 0; i < distances.length; i++)
			distances[i] = (i == start.getIndex())? 0: Integer.MAX_VALUE;
		
		Heap<Node<Integer>> heap = new Heap<Node<Integer>>(graph.getNodes(), -1);
		ArrayList<Node<Integer>> shortestPathFound = new ArrayList<>();
		
		decreaseKey(heap, start, 0);
		while (shortestPathFound.size() != adjacencyList.size()) {
			Node<Integer> current = heap.removeFirst();
			shortestPathFound.add(current);
			for (int i = 0; i < adjacencyList.get(current.getIndex()).size(); i++) {
				if (shortestPathFound.contains(adjacencyList.get(current.getIndex()).get(i)))
					continue;
				distances[adjacencyList.get(current.getIndex()).get(i).getIndex()] = 
						Math.min(distances[adjacencyList.get(current.getIndex()).get(i).getIndex()], 
								distances[current.getIndex()] + edges.get(current.getIndex()).get(adjacencyList.get(current.getIndex()).get(i).getIndex()).getCost());
				decreaseKey(heap, adjacencyList.get(current.getIndex()).get(i), distances[adjacencyList.get(current.getIndex()).get(i).getIndex()]);
			}
		}
		return distances;
	}
	public void decreaseKey(Heap<Node<Integer>> heap, Node<Integer> pointerToNode, int value) {
		pointerToNode.value = value;
		heap.restoreHeapCondition(heap.indexOf(pointerToNode));
	}
	
	/* shortest path tree using Bellman Ford */
	public int[] bellmanford(Node<Integer> start) {
		return new int[] {};
	}
}
