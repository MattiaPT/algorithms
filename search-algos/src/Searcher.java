import java.util.ArrayList;

public class Searcher {
	ArrayList<ArrayList<Integer>> adj;
	
	public Searcher() {
		this(new ArrayList<>());
	}
	public Searcher(ArrayList<ArrayList<Integer>> adj) {
		this.adj = adj;
	}
	
	/*
	 * tests reachability of y from start x using DFS
	 */
	public boolean reachableDFS(int x, int y) {
		if (x == y)
			return true;
		boolean ret = false;
		for (int i : this.adj.get(x))
			ret = ret || reachableDFS(i, y);
		return ret;
	}
	
	
	/* HELPER METHODS */
	public String toString() {
		return adj + "";
	}
}
