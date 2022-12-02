import java.util.Arrays;

public class Sorter {
	int[] arr;
	
	// CONSTRUCTORS
	public Sorter() {
		this(new int[] {});
	}
	public Sorter(int[] arr) {
		this.arr = arr;
	}
	
	// checks if sorted
	public boolean isSorted() {
		for (int i = 0; i < this.arr.length - 1; i++) {
			if (this.arr[i] > this.arr[i+1])
				return false;
		}
		return true;
	}
	
	/* BUBBLESORT */
	public void bubbleSort() {
		for (int i = 0; i < this.arr.length - 1; i++) {
			if (this.arr[i] <= this.arr[i+1])
				continue;
			swap(i, i+1);
			i = -1;
		}
	}
	
	/* SELECTION SORT */
	public void selectionSort() {
		for (int i = 0; i < this.arr.length - 1; i++) {
			// get minimum value in arr[i..n]
			int indexMin = i;
			for (int j = i; j < this.arr.length; j++) {
				if (this.arr[j] < this.arr[indexMin])
					indexMin = j;
			}
			swap(i, indexMin);
		}
	}
	
	/* INSERTION SORT */
	public void insertionSort() {
		for (int i = 1; i < this.arr.length; i++) {
			// binary search location of i in arr[0..i-1]
			int left = 0, right = i-1, middle = 0;
			while (left <= right) {
				middle = (left + right)/2;
				if (this.arr[i] < this.arr[middle])
					right = middle - 1;
				else
					left = middle + 1;
			}
			for (int j = i; j > left; j--) {
				swap(j, j-1);
			}
		}
	}
	
	/* HEAP SORT */
	public void heapSort() {
		for (double i = 0; i < Math.ceil(this.arr.length/2); i++) {
			restoreHeap(this.arr.length);
		}
		for (int i = this.arr.length - 1; i > 0; i--) {
			restoreHeap(i);
			if (this.arr[0] > this.arr[i]) swap(0, i);
		}
	}
	public void restoreHeap(int i) {
		for (int j = 0; j < i;) {
			if (j*2+1 < i && this.arr[2*j+1] >= this.arr[2*j+2] && this.arr[2*j+1] >= this.arr[j]) {
				swap(j, j*2+1);
				j = 2*j+1;
			} else if ((j+1)*2 < i && this.arr[2*j+1] <= this.arr[2*j+2] && this.arr[j] <= this.arr[2*j+2]) {
				swap(j, (j+1)*2);
				j = (j+1)*2;
			} else
				break;
		}
	}
	
	/* HELPER METHODS */
	public void swap(int i, int j) {
		int temp = this.arr[j];
		this.arr[j] = this.arr[i];
		this.arr[i] = temp;
	}
	public String toString() {
		return Arrays.toString(this.arr);
	}
}
