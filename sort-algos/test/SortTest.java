import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class SortTest {
	
	@Test
	public void testIsSorted() {
		Sorter s = new Sorter();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {1, 342, 456, 643, 648, 685, 764};
		assertEquals(true, s.isSorted());
	}
	
	@Test
	public void testBubblesort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.bubblesort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.bubblesort();
		assertEquals(true, s.isSorted());
	}
	
}
