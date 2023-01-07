import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 27.11.22
 * 
 * All algorithms used to sort arrays are being 
 * implemented in this class.
 */

public class Sorter {
	private int[] array;
	
	
	/* CONSTRUCTORS */
	public Sorter() {
		this(new int[] {});
	}
	public Sorter(int[] array) {
		this.array = array;
	}
	
	// checks if sorted
	public boolean isSorted() {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1])
				return false;
		}
		return true;
	}
	
	
	/* BUBBLESORT */
	public void bubbleSort() {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] <= array[i+1])
				continue;
			swap(i, i-- +1);
		}
	}
	
	
	/* SELECTION SORT */
	public void selectionSort() {
		for (int i = 0; i < array.length - 1; i++) {
			// get minimum value in array[i..n]
			int indexMin = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[indexMin])
					indexMin = j;
			}
			swap(i, indexMin);
		}
	}
	
	
	/* INSERTION SORT */
	public void insertionSort() {
		for (int i = 1; i < array.length; i++) {
			// binary search location of i in array[0..i-1]
			int leftPointer = 0, rightPointer = i-1, middlePointer = 0;
			while (leftPointer <= rightPointer) {
				middlePointer = (leftPointer + rightPointer)/2;
				if (array[i] < array[middlePointer])
					rightPointer = middlePointer - 1;
				else
					leftPointer = middlePointer + 1;
			}
			for (int j = i; j > leftPointer; j--) {
				swap(j, j-1);
			}
		}
	}
	
	
	/* HEAP SORT */
	public void heapSort() {
		for (double i = 0; i < Math.ceil(array.length/2); i++) {
			restoreHeap(array.length);
		}
		for (int i = array.length - 1; i > 0; i--) {
			restoreHeap(i);
			if (array[0] > this.array[i]) swap(0, i);
		}
	}
	public void restoreHeap(int i) {
		for (int j = 0; j < i;) {
			if (j*2+1 < i && (2*j+2 == array.length || array[2*j+1] >= array[2*j+2]) && array[2*j+1] >= array[j]) {
				swap(j, j*2+1);
				j = 2*j+1;
			} else if ((j+1)*2 < i && array[2*j+1] <= array[2*j+2] && array[j] <= array[2*j+2]) {
				swap(j, (j+1)*2);
				j = (j+1)*2;
			} else
				break;
		}
	}
	
	
	/* MERGE SORT */
	public void mergeSort() {
		mergeSort(0, array.length/2);
		mergeSort(array.length/2 + 1, array.length - 1);
		merge(0, array.length/2, array.length - 1);
	}
	public void mergeSort(int left, int right) {
		if (left < right) {
			int middlePointer = (left + right)/2;
			mergeSort(left, middlePointer);
			mergeSort(middlePointer + 1, right);
			merge(left, middlePointer, right);
		}
	}
	public void merge(int leftBound, int middleBound, int rightBound) {
		int[] merged = new int[rightBound-leftBound+1];
		int mergePointer = 0;
		int leftPointer = leftBound, middlePointer = middleBound + 1, rightPointer = rightBound;
		
		while (leftPointer <= middleBound && middlePointer <= rightPointer) {
			if (array[leftPointer] < array[middlePointer])
				merged[mergePointer++] = array[leftPointer++];
			else
				merged[mergePointer++] = array[middlePointer++];
		}
		
		// fill up rest
		while (leftPointer <= middleBound)
			merged[mergePointer++] = array[leftPointer++];
		while (middlePointer <= rightPointer)
			merged[mergePointer++] = array[middlePointer++];
		
		for (int i = leftBound; i <= rightBound; i++)
			array[i] = merged[i-rightBound];
	}
	
	
	/* QUICK SORT */
	public void quickSort() {
		quickSort(0, array.length - 1);
	}
	public void quickSort(int leftBound, int rightBound) {
		if (leftBound < rightBound) {
			int partitionPointer = getPartition(leftBound, rightBound);
			quickSort(leftBound, partitionPointer - 1);
			quickSort(partitionPointer + 1, rightBound);
		}
	}
	public int getPartition(int leftBound, int rightBound) {
		int leftPointer = leftBound, rightPointer = rightBound - 1, pivotElement = array[rightBound];
		do {
			while (leftPointer < rightBound && array[rightPointer] <= pivotElement)
				leftPointer++;
			while (rightPointer > leftBound && array[rightPointer] > pivotElement)
				rightPointer--;
			if (leftPointer < rightPointer)
				swap(leftPointer, rightPointer);
		} while (leftPointer < rightPointer);
		swap(leftPointer, rightBound);
		return leftPointer;
	}
	
	
	/* HELPER METHODS */
	public void swap(int i, int j) {
		int temporary = array[j];
		array[j] = array[i];
		array[i] = temporary;
	}
	public String toString() {
		return Arrays.toString(array);
	}
	public void setArray(int[] array) {
		this.array = array;
	}
}
