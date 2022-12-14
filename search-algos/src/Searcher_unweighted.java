import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


public class Searcher_unweighted {
	Graph G;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Node<Integer>>> adj = this.G.getAdjacencyList();
		for (Node<Integer> i : adj.get(x.index))
			ret = ret || (!visited[i.index] && reachableDFSrec(i, y, visited));
		return ret;
	}
	/* iteratively */
	public boolean reachableDFSit(Node<Integer> x, Node<Integer> y) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		@SuppressWarnings("unchecked")
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
		@SuppressWarnings("unchecked")
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
		@SuppressWarnings("unchecked")
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
	
	/* HELPER METHODS */
	public String toString() {
		return G + "";
	}
}
