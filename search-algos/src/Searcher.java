import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;


public class Searcher {
	Graph G;
	
	public Searcher() {
		this(new ArrayList<>());
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Searcher(ArrayList<ArrayList<Integer>> adj) {
		this.G = new Graph(adj);
	}

	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(int x, int y) {
		boolean[] visited = new boolean[this.G.getAdjacencyList().size()];
		return reachableDFSrec(x, y, visited);
	}
	public boolean reachableDFSrec(int x, int y, boolean[] visited) {
		visited[x] = true;
		if (x == y)
			return true;
		boolean ret = false;
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> adj = this.G.getAdjacencyList();
		for (int i : adj.get(x))
			ret = ret || (!visited[i] && reachableDFSrec(i, y, visited));
		return ret;
	}
	/* iteratively */
	public boolean reachableDFSit(int x, int y) {
		Stack<Integer> stack = new Stack<Integer>();
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> adj = this.G.getAdjacencyList();
		boolean[] visited = new boolean[adj.size()];
		stack.push(x);
		while (stack.size() != 0) {
			int p = stack.pop();
			visited[p] = true;
			if (p == y)
				return true;
			for (int i = 0; i < adj.get(p).size(); i++) {
				if (!visited[adj.get(p).get(i)])
					stack.push(adj.get(p).get(i));
			}
		}
		return false;
	}
	
	
	
	/* tests reachability of y from start x using BFS */
	/* recursively */
	public boolean reachableBFSrec(int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.G.getAdjacencyList().size()];
		queue.add(x);
		return helperReachableBFSrec(queue, y, visited);
	}
	public boolean helperReachableBFSrec(Queue<Integer> queue, int y, boolean[] visited) {
		if (queue.size() == 0)
			return false;
		int p = queue.remove();
		visited[p] = true;
		if (p == y)
			return true;
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> adj = this.G.getAdjacencyList();
		for (int i = 0; i < adj.get(p).size(); i++) {
			if (!visited[adj.get(p).get(i)])
				queue.add(adj.get(p).get(i));
		}
		return helperReachableBFSrec(queue, y, visited);
	}
	/* iteratively */
	public boolean reachableBFSit(int x, int y) {
		ArrayList<Integer> queue = new ArrayList<>();
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> adj = this.G.getAdjacencyList();
		boolean[] visited = new boolean[adj.size()];
		queue.add(x);
		while (queue.size() != 0) {
			int p = queue.remove(0);
			visited[p] = true;
			if (p == y)
				return true;
			for (int i = 0; i < adj.get(p).size(); i++) {
				if (!visited[adj.get(p).get(i)])
					queue.add(adj.get(p).get(i));
			}
		}
		return false;
	}
	
	/* HELPER METHODS */
	public String toString() {
		return G + "";
	}
}
