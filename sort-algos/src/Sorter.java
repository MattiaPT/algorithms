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
