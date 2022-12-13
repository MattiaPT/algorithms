import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;


public class Searcher {
	ArrayList<ArrayList<Integer>> adj;
	int[][] c;
	
	public Searcher() {
		this(new ArrayList<>());
	}
	public Searcher(ArrayList<ArrayList<Integer>> adj) {
		this.adj = adj;
	}
	
	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(int x, int y) {
		boolean[] visited = new boolean[this.adj.size()];
		return reachableDFSrec(x, y, visited);
	}
	public boolean reachableDFSrec(int x, int y, boolean[] visited) {
		visited[x] = true;
		if (x == y)
			return true;
		boolean ret = false;
		for (int i : this.adj.get(x))
			ret = ret || (!visited[i] && reachableDFSrec(i, y, visited));
		return ret;
	}
	/* iteratively */
	public boolean reachableDFSit(int x, int y) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[this.adj.size()];
		stack.push(x);
		while (stack.size() != 0) {
			int p = stack.pop();
			visited[p] = true;
			if (p == y)
				return true;
			for (int i = 0; i < this.adj.get(p).size(); i++) {
				if (!visited[this.adj.get(p).get(i)])
					stack.push(this.adj.get(p).get(i));
			}
		}
		return false;
	}
	
	
	
	/* tests reachability of y from start x using BFS */
	/* recursively */
	public boolean reachableBFSrec(int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.adj.size()];
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
		for (int i = 0; i < this.adj.get(p).size(); i++) {
			if (!visited[this.adj.get(p).get(i)])
				queue.add(this.adj.get(p).get(i));
		}
		return helperReachableBFSrec(queue, y, visited);
	}
	/* iteratively */
	public boolean reachableBFSit(int x, int y) {
		ArrayList<Integer> queue = new ArrayList<>();
		boolean[] visited = new boolean[this.adj.size()];
		queue.add(x);
		while (queue.size() != 0) {
			int p = queue.remove(0);
			visited[p] = true;
			if (p == y)
				return true;
			for (int i = 0; i < this.adj.get(p).size(); i++) {
				if (!visited[this.adj.get(p).get(i)])
					queue.add(this.adj.get(p).get(i));
			}
		}
		return false;
	}
	
	
	/* shortest path tree using Dijkstra */
	public int[] Dijkstra(int start) {
		int[] d = new int[this.adj.size()];
		for (int i = 0; i < d.length; i++)
			d[i] = (i == start)? 0: Integer.MAX_VALUE;
		int[] elements = {10, 3, 2, 5, 123, 5};
		Node[] nodes = new Node[elements.length];
		for (int i = 0; i < elements.length; i++)
			nodes[i] = new Node(elements[i]);
		
		Heap<Node<Integer>> H = new Heap<Node<Integer>>(nodes, false);
		HashSet<Node<Integer>> S = new HashSet<>(Arrays.asList(nodes));
		
		while (S.size() != this.adj.size()) {
			Node<Integer> v = H.removeFirst();
			S.add(v);
			for (int i = 0; i < this.adj.get(v.value).size(); i++) {
				if (S.contains(this.adj.get(v.value).get(i)))
					continue;
				d[this.adj.get(v.value).get(i)] = Math.min(d[this.adj.get(v.value).get(i)], d[v.value] + c[this.adj.get(v.value).get(i)][v.value]);
				decreaseKey(H, this.adj.get(v.value).get(i), d[this.adj.get(v.value).get(i)]);
			}
		}
		return d;
	}
	public void decreaseKey(Heap H, Node ptr, int value) {
		S.
	}
	
	/* HELPER METHODS */
	public String toString() {
		return adj + "";
	}
}
