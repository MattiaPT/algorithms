import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{
	ArrayList<T> H;
	boolean min;
	
	public Heap(T[] elements, boolean min) {
		H = new ArrayList<T>();
		for (T element : elements)
			H.add(element);
		this.min = min;
		for (int i = this.H.size()/2; i >= 0 ; i--) {
			restoreHeapCondition(i);
			if (0 < this.H.get(0).compareTo(this.H.get(i)))
				swap(0, i);
		}
	}
	
	public void restoreHeapCondition(int i) {
		for (int j = i; j < H.size();) {
			if (j*2+1 < this.H.size() && (j*2+2 == this.H.size() || 0 <= this.H.get(2*j+1).compareTo(this.H.get(2*j+2))) && 0 <= this.H.get(2*j+1).compareTo(this.H.get(j))) {
				swap(j, j*2+1);
				j = 2*j + 1;
			} else if ((j+1)*2 < this.H.size() && 0 <= this.H.get((j+1)*2).compareTo(this.H.get(2*j+1)) && 0 <= this.H.get((j+1)*2).compareTo(this.H.get(j)) ) {
				swap(j, (j+1)*2);
				j = (j+1)*2;
			} else
				break;
		}
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
