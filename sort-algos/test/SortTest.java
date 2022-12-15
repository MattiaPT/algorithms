import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 27.11.22
 * 
 * Here tests will be added for every new sort algorithm implemented.
 */


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
		s.bubbleSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.bubbleSort();
		assertEquals(true, s.isSorted());
	}
	@Test
	public void testSelectionsort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.selectionSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.selectionSort();
		assertEquals(true, s.isSorted());
	}
	@Test
	public void testInsertionsort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.insertionSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.insertionSort();
		assertEquals(true, s.isSorted());
	}
	@Test
	public void testHeapSort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.heapSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.heapSort();
		assertEquals(true, s.isSorted());
	}
	@Test
	public void testMergeSort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.mergeSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.mergeSort();
		assertEquals(true, s.isSorted());
	}
	@Test
	public void testQuickSort() {
		Sorter s = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		s.quickSort();
		assertEquals(true, s.isSorted());
		
		s.arr = new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9};
		s.quickSort();
		assertEquals(true, s.isSorted());
	}
}
