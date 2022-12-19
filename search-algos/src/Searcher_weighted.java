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
		int[] distances = new int[graph.getNodes().size()];
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
		ArrayList<Node<Integer>> nodes = graph.getNodes();
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = graph.getAdjacencyList();
		ArrayList<ArrayList<Edge<Integer>>> edges = graph.getEdges();
		int[] distances = new int[graph.getNodes().size()];
		for (int i = 0; i < distances.length; i++)
			distances[i] = (i == start.getIndex())? 0: Integer.MAX_VALUE/2;
		for (int a = 0; a < nodes.size()-1; a++) {
			for (int i = 0; i < nodes.size(); i++) {
				int minimalEdgeCost = Integer.MAX_VALUE;
				for (int j = 0; j < edges.size(); j++) {
					if (adjacencyList.get(j).contains(nodes.get(i)) && 
							distances[edges.get(j).get(i).getStart().getIndex()] + edges.get(j).get(i).getCost() < minimalEdgeCost)
						minimalEdgeCost = distances[edges.get(j).get(i).getStart().getIndex()] + edges.get(j).get(i).getCost();
				}
				if (distances[nodes.get(i).getIndex()] > minimalEdgeCost)
					distances[nodes.get(i).getIndex()] = minimalEdgeCost;
			}
		}
		return distances;
	}
	
	/* minimal spanning tree using Boruvka */
	public Graph Boruvka() {
		ArrayList<ArrayList<Node<Integer>>> adjacencyList = new ArrayList<ArrayList<Node<Integer>>>();
		for (int i = 0; i < graph.getNodes().size(); i++)
			adjacencyList.add(new ArrayList<Node<Integer>>());
		Graph MST = new Graph(graph.getNodes(), adjacencyList);
		ArrayList<ArrayList<Edge<Integer>>> edges = graph.getEdges();
		ArrayList<ArrayList<Node<Integer>>> ZHKs = new ArrayList<ArrayList<Node<Integer>>>();
		for (int i = 0; i < graph.getNodes().size(); i++) {
			ZHKs.add(new ArrayList<Node<Integer>>());
			ZHKs.get(i).add((Node<Integer>) graph.getNodes().get(i));
		} 
			
		while (ZHKs.size() != 1) {
			for (ArrayList<Node<Integer>> ZHK : ZHKs) {
				Edge<Integer> minEdge = new Edge(null, null, Integer.MAX_VALUE);
				for (Node<Integer> node : ZHK) {
					for (Node<Integer> neighbour : adjacencyList.get(node.getIndex())) {
						int index = neighbour.getIndex();
						if (minEdge.getCost() < edges.get(node.getIndex()).get(index).getCost())
							continue;
						minEdge = edges.get(node.getIndex()).get(index);
					}
				}
				MST.addEdge(minEdge.getStart(), minEdge.getEnd(), minEdge.getCost());
				ZHKs = MST.getZHKs();
			}
		}
		return MST; 
	}
}
