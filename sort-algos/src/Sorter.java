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
	public void bubblesort() {
		for (int i = 0; i < this.arr.length - 1; i++) {
			if (this.arr[i] <= this.arr[i+1])
				continue;
			swap(i, i+1);
			i = -1;
		}
	}
	
	/* SELECTION SORT */
	public void selectionsort() {
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
	public void insertionsort() {
		for (int i = 0; i < this.arr.length; i++) {
			// binary search location of i in arr[0..i-1]
			int left = 0, right = i, middle = 0;
			while (left < right) {
				middle = (left + right)/2;
				if (this.arr[i] == this.arr[middle])
					break;
				else if (this.arr[i] < this.arr[middle])
					right = middle - 1;
				else
					left = middle + 1;
			}
			for (int j = i; j > middle; j--) {
				swap(j, j-1);
			}
			System.out.println(Arrays.toString(this.arr));
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
