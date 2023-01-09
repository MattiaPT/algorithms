
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
	
	/* INTERPOLATION SEARCH */
	public int interpolationSearch(int value) {
		int left = 0, expectation, right = array.length - 1;
		while (left <= right) {
			expectation = (int)((left + right) * ((double) (value - array[left]))/(array[right] - array[left]));
			if (array[expectation] == value)
				return expectation;
			if (array[expectation] < value)
				left = expectation + 1;
			else
				right = expectation - 1;
		}
		
		return left;
	}
	
	/* EXPONENTIAL SEARCH */
	public int exponentialSearch(int value) {
		int left = 0, middle, right = 1;
		while (array[right] < value && right != array.length - 1) {
			left = right;
			right = (right * 2 < array.length)? right * 2: array.length - 1;
		}

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
