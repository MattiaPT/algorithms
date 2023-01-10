import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import SortAlgorithms.Sorter;

/*
 * Author: Mattia
 * Date: 27.11.22
 * 
 * Here tests will be added for every sort algorithm implemented.
 */


public class SortTest {
	
	@Test
	public void testIsSorted() {
		Sorter sorter = new Sorter();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {1, 342, 456, 643, 648, 685, 764});
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testBubblesort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.bubbleSort();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.bubbleSort();
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testSelectionsort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.selectionSort();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.selectionSort();
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testInsertionsort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.insertionSort();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.insertionSort();
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testHeapSort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.heapSort();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.heapSort();
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testMergeSort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.mergeSort();
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.mergeSort();
		assertEquals(true, sorter.isSorted());
	}
	@Test
	public void testQuickSort() {
		Sorter sorter = new Sorter(new int[] {124, 643, 1234, 34, 2, 4, 0, 12});
		sorter.quickSort();
		System.out.println(sorter);
		assertEquals(true, sorter.isSorted());
		
		sorter.setArray(new int[] {12, 53, 2, 3, 5, 5, 2, 1, 2, 9});
		sorter.quickSort();
		assertEquals(true, sorter.isSorted());
	}
}
