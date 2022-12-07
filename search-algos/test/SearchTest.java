import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class SearchTest {
	
	@Test
	public void testReachableDFSrec() {
		Searcher s = new Searcher(createArrayList());
		
		assertEquals(true, s.reachableDFSrec(7, 6));
		assertEquals(false, s.reachableDFSrec(6, 7));
		
		assertEquals(true, s.reachableDFSrec(0, 6));
		assertEquals(false, s.reachableDFSrec(0, 1));
		
	}
	
	@Test
	public void testReachableDFSit() {
		Searcher s = new Searcher(createArrayList());
		
		assertEquals(true, s.reachableDFSit(7, 6));
		assertEquals(false, s.reachableDFSit(6, 7));
		
		assertEquals(true, s.reachableDFSit(0, 6));
		assertEquals(false, s.reachableDFSit(0, 1));
		
	}
	
	@Test
	public void testReachableBFSrec() {
		Searcher s = new Searcher(createArrayList());
		
		assertEquals(true, s.reachableBFSrec(7, 6));
		assertEquals(false, s.reachableBFSrec(6, 7));
		
		assertEquals(true, s.reachableBFSrec(0, 6));
		assertEquals(false, s.reachableBFSrec(0, 1));
		
	}
	
	@Test
	public void testReachableBFSit() {
		Searcher s = new Searcher(createArrayList());
		
		assertEquals(true, s.reachableBFSit(7, 6));
		assertEquals(false, s.reachableBFSit(6, 7));
		
		assertEquals(true, s.reachableBFSit(0, 6));
		assertEquals(false, s.reachableBFSit(0, 1));
		
	}
	
	public ArrayList<ArrayList<Integer>> createArrayList() {
		ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < 8; i++)
			n.add(new ArrayList<>());
		
		n.get(0).add(3);
		n.get(1).add(0);
		n.get(1).add(3);
		n.get(2).add(1);
		n.get(2).add(4);
		n.get(3).add(5);
		n.get(4).add(3);
		n.get(4).add(6);
		n.get(5).add(6);
		n.get(7).add(4);
		
		return n;
	}
}
