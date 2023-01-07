import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * Here tests will be added for every search algorithm implemented.
 */

public class SearchTest {
	@Test
	public void testBinarySearchit() {
		Searcher test1 = new Searcher(new int[] {1, 6, 8, 11, 20, 42, 44, 45, 210});
		assertEquals(6, test1.binarySearchit(44));
	}
	
	@Test
	public void testInterpolationSearch() {
		Searcher test1 = new Searcher(new int[] {1, 6, 8, 11, 20, 42, 44, 45, 60});
		assertEquals(6, test1.interpolationSearch(44));
	}
	
	@Test
	public void testExponentialSearch() {
	}
}
