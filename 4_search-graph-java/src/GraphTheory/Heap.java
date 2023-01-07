package GraphTheory;
import java.util.ArrayList;

/*
 * Author: Mattia
 * Date: 09.12.22
 * 
 * This class is being used to store any comparable Type T in a heap structure,
 * providing useful methods to implement both min- and max-heap structures.
 * -> the type attribute can either be set to -1, or to 1:
 *    -1 -> min-heap structure
 *     1 -> max-heap structure
 */

public class Heap<T extends Comparable<T>>{
	private ArrayList<T> heap;
	private int type;
	
	
	/* CONSTRUCTORS */
	public Heap(ArrayList<T> elements, int type) {
		heap = new ArrayList<T>();
		for (T element : elements)
			heap.add(element);
		this.type = type;
		restoreHeapCondition();
	}
	
	
	public void restoreHeapCondition() {
		for (int i = heap.size()/2; i >= 0 ; i--) {
			restoreHeapCondition(i);
			if (0 < heap.get(0).compareTo(heap.get(i)))
				swap(0, i);
		}
	}
	public void restoreHeapCondition(int i) {
		for (int j = i; j < heap.size();) {
			if (j*2+1 < heap.size() && 
					(0 <= type*heap.get(2*j+1).compareTo(heap.get(j)) && 
					(j*2+2 == heap.size() || 0 <= type*heap.get(2*j+1).compareTo(heap.get(2*j+2))))) {
				swap(j, j*2+1);
				j = 2*j + 1;
			} else if (j*2+2 < heap.size() && 
					0 <= type*heap.get(j*2+2).compareTo(heap.get(2*j+1)) &&
					0 <= type*heap.get((j+1)*2).compareTo(heap.get(j))) {
				swap(j, j*2+2);
				j = 2*j + 2;
			} else
				break;
		}
	}
	
	
	/* HELPER METHODS */
	public T removeFirst() {
		T ret = heap.remove(0);
		if (heap.size() != 0)
			restoreHeapCondition();
		return ret;
	}
	public int indexOf(T n) {
		return heap.indexOf(n);
	}
	public int size() {
		return heap.size();
	}
	public void swap(int i, int j) {
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	public String toString() {
		return heap + "";
	}
}
