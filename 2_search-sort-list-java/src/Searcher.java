import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * All algorithms used to search in sorted arrays are being 
 * implemented in this class.
 */

public class Searcher {
	private int[] array;

	/* CONSTRUCTORS */
	public Searcher(int[] array) {
		this.array = array;
	}
	
	/* BINARY SEARCH */
	public int binarySearchit(int value) {
		int left = 0, middle, right = array.length - 1;
		while (left <= right) {
			middle = (left + right) / 2;
			if (array[middle] == value)
				return middle;
			if (array[middle] < value)
				left = middle + 1;
			else
				right = middle - 1;
		}
		
		return left;
	}
}
