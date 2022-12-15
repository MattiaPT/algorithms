import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Searcher_unweighted {
	Graph G;
	
	public Searcher_unweighted(ArrayList<Node<Integer>> nodes, ArrayList<ArrayList<Node<Integer>>> adj) {
		this.G = new Graph(nodes, adj);
	}

	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(Node<Integer> x, Node<Integer> y) {
		boolean[] visited = new boolean[this.G.getAdjacencyList().size()];
		return reachableDFSrec(x, y, visited);
	}
	public boolean reachableDFSrec(Node<Integer> x, Node<Integer> y, boolean[] visited) {
		visited[x.index] = true;
		if (x.index == y.index)
			return true;
		boolean ret = false;
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		for (Node<Integer> i : adj.get(x.index))
			ret = ret || (!visited[i.index] && reachableDFSrec(i, y, visited));
		return ret;
	}
	/* iteratively */
	public boolean reachableDFSit(Node<Integer> x, Node<Integer> y) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		boolean[] visited = new boolean[adj.size()];
		stack.push(x);
		while (stack.size() != 0) {
			Node<Integer> p = stack.pop();
			visited[p.index] = true;
			if (p.index == y.index)
				return true;
			for (int i = 0; i < adj.get(p.index).size(); i++) {
				if (!visited[adj.get(p.index).get(i).index])
					stack.push(adj.get(p.index).get(i));
			}
		}
		return false;
	}
	
	
	
	/* tests reachability of y from start x using BFS */
	/* recursively */
	public boolean reachableBFSrec(Node<Integer> x, Node<Integer> y) {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		boolean[] visited = new boolean[this.G.getAdjacencyList().size()];
		queue.add(x);
		return helperReachableBFSrec(queue, y, visited);
	}
	public boolean helperReachableBFSrec(Queue<Node<Integer>> queue, Node<Integer> y, boolean[] visited) {
		if (queue.size() == 0)
			return false;
		Node<Integer> p = queue.remove();
		visited[p.index] = true;
		if (p.index == y.index)
			return true;
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		for (int i = 0; i < adj.get(p.index).size(); i++) {
			if (!visited[adj.get(p.index).get(i).index])
				queue.add(adj.get(p.index).get(i));
		}
		return helperReachableBFSrec(queue, y, visited);
	}
	/* iteratively */
	public boolean reachableBFSit(Node<Integer> x, Node<Integer> y) {
		ArrayList<Node<Integer>> queue = new ArrayList<>();
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		boolean[] visited = new boolean[adj.size()];
		queue.add(x);
		while (queue.size() != 0) {
			Node<Integer> p = queue.remove(0);
			visited[p.index] = true;
			if (p.index == y.index)
				return true;
			for (int i = 0; i < adj.get(p.index).size(); i++) {
				if (!visited[adj.get(p.index).get(i).index])
					queue.add(adj.get(p.index).get(i));
			}
		}
		return false;
	}
	
	/* get shortest path from x to y in a graph with unweighted edges using BFS */
	/* iteratively */
	public int shortestPathBFSit(Node<Integer> x, Node<Integer> y) {
		ArrayList<Node<Integer>> queue = new ArrayList<Node<Integer>>();
		ArrayList<Integer> distance = new ArrayList<Integer>();
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		boolean[] visited = new boolean[adj.size()];
		
		queue.add(x);
		distance.add(0);
		while (queue.size() != 0) {
			Node<Integer> p = queue.remove(0);
			if (p.index == y.index)
				return distance.get(0);
			int dist = distance.remove(0);
			visited[p.index] = true;
			for (int i = 0; i < adj.get(p.index).size(); i++) {
				if (!visited[adj.get(p.index).get(i).index]) {
					queue.add(adj.get(p.index).get(i));
					distance.add(dist+1);
				}
			}
		}
		return -1;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		return G + "";
	}
}














































