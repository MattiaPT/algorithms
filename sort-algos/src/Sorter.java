class Sorter {
    public int[] arr;

    // CONSTRUCTORS
    public Sorter() {
	this(new int[] {});
    }
    public Sorter(int[] arr) {
	this.arr = arr;
    }

    // CHECK IF SORTED
    public boolean isSorted() {
	for (int i = 0; i < this.arr.length - 1; i++) {
	    if (this.arr[i] > this.arr[i+1])
		return false;
	}
	return true;
    }
}
