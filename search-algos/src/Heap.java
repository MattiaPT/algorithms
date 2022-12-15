import java.util.ArrayList;

/*
 * Author: Mattia
 * Date: 09.12.22
 * 
 * This class is being used to store any comparable Type T in a heap structure,
 * providing useful methods to implement both min- and max-heap structures.
 */

public class Heap<T extends Comparable<T>>{
	private ArrayList<T> H;
	private boolean min;
	
	
	/* CONSTRUCTORS */
	public Heap(ArrayList<T> elements, boolean min) {
		H = new ArrayList<T>();
		for (T element : elements)
			H.add(element);
		this.min = min;
		restoreHeapCondition();
	}
	
	
	public void restoreHeapCondition() {
		for (int i = this.H.size()/2; i >= 0 ; i--) {
			restoreHeapCondition(i);
			if (0 < this.H.get(0).compareTo(this.H.get(i)))
				swap(0, i);
		}
	}
	public void restoreHeapCondition(int i) {
		for (int j = i; j < H.size();) {
			if (j*2+1 < this.H.size() && (0 >= this.H.get(2*j+1).compareTo(this.H.get(j)) && (j*2+2 == this.H.size() || 0 >= this.H.get(2*j+1).compareTo(this.H.get(2*j+2))))) {
				swap(j, j*2+1);
				j = 2*j + 1;
			} else if (j*2+2 < this.H.size() && 0 >= this.H.get(j*2+2).compareTo(this.H.get(2*j+1)) && 0 >= this.H.get((j+1)*2).compareTo(this.H.get(j)) ) {
				swap(j, j*2+2);
				j = 2*j + 2;
			} else
				break;
		}
	}
	
	
	/* HELPER METHODS */
	public T removeFirst() {
		T ret = H.remove(0);
		if (H.size() != 0)
			restoreHeapCondition();
		return ret;
	}
	public int indexOf(T n) {
		return H.indexOf(n);
	}
	public int size() {
		return H.size();
	}
	public void swap(int i, int j) {
		T temp = H.get(i);
		H.set(i, H.get(j));
		H.set(j, temp);
	}
	public String toString() {
		return this.H + "";
	}
}
