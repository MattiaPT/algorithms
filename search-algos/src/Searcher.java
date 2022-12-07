import java.util.ArrayList;

public class Searcher {
	ArrayList<ArrayList<Integer>> adj;
	
	public Searcher() {
		this(new ArrayList<>());
	}
	public Searcher(ArrayList<ArrayList<Integer>> adj) {
		this.adj = adj;
	}
	
	/* tests reachability of y from start x using DFS */
	/* recursively */
	public boolean reachableDFSrec(int x, int y) {
		if (x == y)
			return true;
		boolean ret = false;
		for (int i : this.adj.get(x))
			ret = ret || reachableDFSrec(i, y);
		return ret;
	}
	/* iteratively */
	public boolean reachableDFSit(int x, int y) {
		ArrayList<Integer> stack = new ArrayList<>();
		stack.add(x);
		while (stack.size() != 0) {
			int p = stack.remove(0);
			if (p == y)
				return true;
			for (int i = 0; i < this.adj.get(p).size(); i++) {
				stack.add(0, adj.get(p).get(i));
			}
		}
		return false;
	}
	
	
	
	/* tests reachability of y from start x using BFS */
	/* iteratively */
	public boolean reachableBFSit(int x, int y) {
		ArrayList<Integer> queue = new ArrayList<>();
		queue.add(x);
		while (queue.size() != 0) {
			int p = queue.remove(0);
			if (p == y)
				return true;
			for (int i = 0; i < this.adj.get(p).size(); i++) {
				queue.add(this.adj.get(p).get(i));
			}
		}
		return false;
	}
	
	/* HELPER METHODS */
	public String toString() {
		return adj + "";
	}
}
